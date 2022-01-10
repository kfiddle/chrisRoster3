package com.example.demo.controllers;


import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.PerformanceAdder;
import com.example.demo.models.performance.PerformanceBuilder;
import com.example.demo.models.performance.PerformanceMaker;
import com.example.demo.models.piece.PieceBuilder;
import com.example.demo.repositories.PerformanceRepo;
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



    @RequestMapping("/get-all-performances")
    public Collection<Performance> getAllPerformances() {
        List<Performance> sortedPerformances = new ArrayList<>((Collection<Performance>) performanceRepo.findAll());
        Collections.sort(sortedPerformances);
        return sortedPerformances;
    }

//    @PostMapping("/add-performance")
//    public Collection<Performance> addAShow(@RequestBody Performance incomingPerformance) throws IOException {
//        if (!performanceRepo.existsByTitle(incomingPerformance.getTitle())) {
//            Performance performanceToAdd = PerformanceMaker.makeFrom(incomingPerformance);
//            performanceRepo.save(performanceToAdd);
//        }
//        return (Collection<Performance>) performanceRepo.findAll();
//    }

//    @PostMapping("/add-performance")
//    public Collection<Performance> addAShow(@RequestBody PerformanceAdder incoming) throws IOException {
//
//        try {
//            if (!performanceRepo.existsByTitle(incoming.performance.getTitle())) {
//                if (incoming.piecesSubmitted()) {
//                    pieceOnProgramRepo.saveAll(incoming.mappedPiecesToShow());
//                    incoming.showTunes = incoming.mappedPiecesToShow();
//                    for (PieceOnProgram piece : pieceOnProgramRepo.findAll()) {
//                        System.out.println(piece.getPiece().getTitle());
//                    }
//                }
//                performanceRepo.save(PerformanceMaker.makeFrom(incoming));
//            }
//        } catch (
//                Exception error) {
//            error.printStackTrace();
//        }
//
//        return (Collection<Performance>) performanceRepo.findAll();
//    }

    @PostMapping("/get-pieces-on-program")
    public List<PieceOnProgram> getPiecesOnAShow(@RequestBody Performance incomingPerformance) throws IOException {
        Optional<Performance> performanceToFind = performanceRepo.findById(incomingPerformance.getId());
        if (performanceToFind.isPresent()) {
            Performance performanceToGrabPieces = performanceToFind.get();
            return performanceToGrabPieces.getProgram();
        }
        return null;
    }

}
