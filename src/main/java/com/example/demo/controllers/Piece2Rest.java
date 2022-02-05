package com.example.demo.controllers;

import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;
import com.example.demo.models.piece.PieceMaker;
import com.example.demo.repositories.take2Repos.Piece2Repo;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.Collection;

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



}
