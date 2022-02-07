package com.example.demo.controllers;


import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.junctions.ShowTune;
import com.example.demo.models.performance.*;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;
import com.example.demo.repositories.take2Repos.Piece2Repo;
import com.example.demo.repositories.take2Repos.ShowRepo;
import com.example.demo.repositories.take2Repos.ShowTuneRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class ShowRest {

    @Resource
    ShowRepo showRepo;

    @Resource
    ShowTuneRepo showTuneRepo;

    @Resource
    Piece2Repo piece2Repo;

    @RequestMapping("/get-all-performances")
    public Collection<Show> getAllShows() {
        List<Show> sortedShows = new ArrayList<>((Collection<Show>) showRepo.findAll());

        try {
            Collections.sort(sortedShows);
            return sortedShows;

        } catch (Exception error){
            error.printStackTrace();
        }

        return (Collection<Show>) showRepo.findAll();

    }

    @PostMapping("/add-performance")
    public Collection<Show> addAShow(@RequestBody ShowAdder incoming) throws IOException {

        try {
            if (!showRepo.existsByTitle(incoming.show.getTitle())) {
                showRepo.save(PerformanceMaker.makeUsing(incoming.show));

                if (!incoming.piecesToAdd.isEmpty()) {
                    for (Piece2 piece : incoming.piecesToAdd) {
                        ShowTune pieceOnShow = new ShowTune(piece, showRepo.findByTitle(incoming.show.getTitle()), incoming.piecesToAdd.indexOf(piece) + 1);
                        showTuneRepo.save(pieceOnShow);
                    }
                }
            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }

        return (Collection<Show>) showRepo.findAll();
    }

    @PostMapping("/get-pieces-on-program")
    public List<ShowTune> getPiecesOnAShow(@RequestBody Show incomingShow) throws IOException {

        try {
            List<ShowTune> showTunes = (List<ShowTune>) showTuneRepo.findAllByShow(incomingShow);
            Collections.sort(showTunes);
            return showTunes;
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

}
