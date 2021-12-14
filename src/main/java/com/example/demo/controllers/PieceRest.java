package com.example.demo.controllers;

import com.example.demo.models.Piece;
import com.example.demo.models.PieceMaker;
import com.example.demo.repositories.PieceRepo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

@CrossOrigin
@RestController
public class PieceRest {

    @Resource
    PieceRepo pieceRepo;

    @RequestMapping("/get-all-pieces")
    public Collection<Piece> getAllPerformances() {
        return (Collection<Piece>) pieceRepo.findAll();
    }

    @PostMapping("/add-piece")
    public Collection<Piece> addPieceToDatabase(@RequestBody Piece incomingPiece) throws IOException {

        try {
            Piece newPiece = PieceMaker.makeFrom(incomingPiece);
            pieceRepo.save(newPiece);
            System.out.println(newPiece.getTitle());
            System.out.println(newPiece.getDuration());

        } catch (
                Exception error) {
            error.printStackTrace();
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

}
