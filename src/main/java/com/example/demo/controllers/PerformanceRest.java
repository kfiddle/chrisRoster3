package com.example.demo.controllers;


import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.PerformanceAdder;
import com.example.demo.models.performance.PerformanceBuilder;
import com.example.demo.models.performance.PerformanceMaker;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.PieceBuilder;
import com.example.demo.repositories.PerformanceRepo;
import com.example.demo.repositories.PieceOnProgramRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
public class PerformanceRest {

    @Resource
    PerformanceRepo performanceRepo;

    @Resource
    PieceOnProgramRepo pieceOnProgramRepo;


    @RequestMapping("/get-all-performances")
    public Collection<Performance> getAllPerformances() {
        List<Performance> sortedPerformances = new ArrayList<>((Collection<Performance>) performanceRepo.findAll());

        try {
            Collections.sort(sortedPerformances);
            return sortedPerformances;

        } catch (Exception error){
            error.printStackTrace();
        }

        return (Collection<Performance>) performanceRepo.findAll();

    }

    @PostMapping("/add-performance")
    public Collection<Performance> addAShow(@RequestBody PerformanceAdder incoming) throws IOException {

        try {
            if (!performanceRepo.existsByTitle(incoming.performance.getTitle())) {
                performanceRepo.save(PerformanceMaker.makeFrom(incoming));

                if (incoming.piecesSubmitted()) {
                    for (Piece piece : incoming.piecesToAdd) {
                        PieceOnProgram pieceOnShow = new PieceOnProgram(piece, performanceRepo.findByTitle(incoming.performance.getTitle()));
                        incoming.showTunes.add(pieceOnShow);
                        pieceOnProgramRepo.save(pieceOnShow);
                    }

                }
            }
        } catch (
                Exception error) {
            error.printStackTrace();
        }

        return (Collection<Performance>) performanceRepo.findAll();
    }

    @PostMapping("/get-pieces-on-program")
    public List<PieceOnProgram> getPiecesOnAShow(@RequestBody Performance incomingPerformance) throws IOException {

        try {
            List<PieceOnProgram> showTunes = (List<PieceOnProgram>) pieceOnProgramRepo.findAllByPerformance(incomingPerformance);
            Collections.sort(showTunes);
            return showTunes;
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}



