package com.example.demo.controllers;

import com.example.demo.junctions.ShowTune;
import com.example.demo.models.piece.*;
import com.example.demo.models.showTunePlayer.PlayerInChair;
import com.example.demo.repositories.take2Repos.Piece2Repo;
import com.example.demo.repositories.take2Repos.PlayerInChairRepo;
import com.example.demo.repositories.take2Repos.ShowTuneRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class Piece2Rest {

    @Resource
    Piece2Repo piece2Repo;

    @Resource
    ShowTuneRepo showTuneRepo;

    @Resource
    PlayerInChairRepo playerInChairRepo;

    @RequestMapping("/get-all-pieces")
    public Collection<Piece2> getAllPerformances() {
        return (Collection<Piece2>) piece2Repo.findAll();
    }

    @PostMapping("/add-piece")
    public Collection<Piece2> addPieceToDatabase(@RequestBody Piece2 incomingPiece) throws IOException {

        try {
            Piece2 newPiece = PieceMaker.makeUsing(incomingPiece);
            piece2Repo.save(newPiece);

        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece2>) piece2Repo.findAll();
    }

    @RequestMapping("get-sorted-pieces/{sortType}")
    public Collection<Piece2> getSortedPieces(@PathVariable String sortType) {
        try {
            return piece2Repo.findAllBy(Sort.by(sortType));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add-all-empty-chairs/{pieceId}")
    public Optional<Piece2> addFullOrchestration(@PathVariable Long pieceId, @RequestBody Collection<EmptyChair> incomingChairs) throws IOException {


        Optional<Piece2> pieceCheck = piece2Repo.findById(pieceId);

        for (EmptyChair emptyChair : incomingChairs) {
            System.out.println(emptyChair.getPrimaryPart() + "    " + emptyChair.getRank());
            if (emptyChair.getSecondaryPart() != null) {
                System.out.println(emptyChair.getSecondaryPart());
            }
        }


        if (pieceCheck.isPresent()) {
            Piece2 pieceToAttachOrch = pieceCheck.get();
            pieceToAttachOrch.setEmptyChairs(incomingChairs);

            piece2Repo.save(pieceToAttachOrch);

            if (showTuneRepo.existsByPiece2(pieceToAttachOrch)) {
                for (ShowTune showTune : showTuneRepo.findAllByPiece2(pieceToAttachOrch)) {
                      playerInChairRepo.saveAll(showTune.makeSomeEmptyChairs());
                }
            }

            for (PlayerInChair playerInChair : playerInChairRepo.findAll()) {
                System.out.println(playerInChair.getPrimaryPart() + "    " + playerInChair.getRank());
            }

        }


        return pieceCheck;
    }


}
