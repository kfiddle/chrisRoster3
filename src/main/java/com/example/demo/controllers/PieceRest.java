package com.example.demo.controllers;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.NumbOnPart;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.PieceMaker;
//import com.example.demo.repositories.PieceOnProgramRepo;
import com.example.demo.repositories.PieceOnProgramRepo;
import com.example.demo.repositories.PieceRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class PieceRest {

    @Resource
    PieceRepo pieceRepo;

    @Resource
    PieceOnProgramRepo ppRepo;

    @RequestMapping("/get-all-pieces")
    public Collection<Piece> getAllPerformances() {
        return (Collection<Piece>) pieceRepo.findAll();
    }


    @PostMapping("/add-piece")
    public Collection<Piece> addPieceToDatabase(@RequestBody Piece incomingPiece) throws IOException {

        try {
            Piece newPiece = PieceMaker.makeFrom(incomingPiece);
            pieceRepo.save(newPiece);
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @PostMapping("edit-piece")
    public Collection<Piece> editPieceInDatabase(@RequestBody Piece incomingPiece) throws IOException {

        Optional<Piece> pieceToFind = pieceRepo.findById(incomingPiece.getId());
        if (pieceToFind.isPresent()) {
            Piece pieceToEdit = pieceToFind.get();
            pieceToEdit.setAllProps(incomingPiece);
            pieceRepo.save(pieceToEdit);
        }
        return (Collection<Piece>) pieceRepo.findAll();
    }


    @RequestMapping("get-sorted-pieces/{sortType}")
    public Collection<Piece> getSortedPieces(@PathVariable String sortType) {
        try {
            return pieceRepo.findAllBy(Sort.by(sortType));
        } catch (
                Exception error) {
            error.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add-full-orchestration")
    public Optional<Piece> addFullOrchestration(@RequestBody Piece incomingPiece) throws IOException {

        Optional<Piece> pieceCheck = pieceRepo.findById(incomingPiece.getId());
        if (pieceCheck.isPresent()) {
            Piece pieceToAttachOrch = pieceCheck.get();
            pieceToAttachOrch.setOrchestration(incomingPiece.getOrchestration());
            pieceRepo.save(pieceToAttachOrch);

            if (ppRepo.existsByPiece(pieceToAttachOrch)) {
                Collection<PieceOnProgram> ppsToGetChairs = ppRepo.findAllByPiece(pieceToAttachOrch);
                for (PieceOnProgram pp : ppsToGetChairs) {
                    pp.makeSomeEmptyChairs();
                    ppRepo.save(pp);
                }
            }
        }

        return pieceCheck;
    }


}
