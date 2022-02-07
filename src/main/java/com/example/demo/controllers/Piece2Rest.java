package com.example.demo.controllers;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.piece.*;
import com.example.demo.repositories.take2Repos.Piece2Repo;
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

    @PostMapping("/add-all-scorelines/{pieceId}")
    public Optional<Piece2> addFullOrchestration(@PathVariable Long pieceId, @RequestBody ScoreLinesCollection incomingLines) throws IOException {


        Optional<Piece2> pieceCheck = piece2Repo.findById(pieceId);
        if (pieceCheck.isPresent()) {
            Piece2 pieceToAttachOrch = pieceCheck.get();
            pieceToAttachOrch.setScoreLines(incomingLines.scoreLines);

            piece2Repo.save(pieceToAttachOrch);

            for (ScoreLine scoreLine : pieceToAttachOrch.getScoreLines()) {
                System.out.println(scoreLine.getPrimaryPart() + "     " + scoreLine.getRank());
                if (scoreLine.getSecondaryPart() != null) {
                    System.out.println(" and doubling on " +  scoreLine.getSecondaryPart());
                }
            }

//            if (ppRepo.existsByPiece(pieceToAttachOrch)) {
//                Collection<PieceOnProgram> ppsToGetChairs = ppRepo.findAllByPiece(pieceToAttachOrch);
//                for (PieceOnProgram pp : ppsToGetChairs) {
//                    pp.makeSomeEmptyChairs();
//                    ppRepo.save(pp);
//                }
//            }

//            for (ScoreLine scoreLine : pieceToAttachOrch.getScoreLines()) {
//                System.out.println(scoreLine.getPrimaryPart() + "     " + scoreLine.getRank());
//            }
        }


        return pieceCheck;
    }


}
