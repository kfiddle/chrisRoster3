package com.example.demo.controllers;


import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.junctions.PlayerPlacer;
import com.example.demo.models.player.Player;
import com.example.demo.repositories.PieceOnProgramRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Optional;

@CrossOrigin
@RestController
public class PieceOnProgramRest {


    @Resource
    PieceOnProgramRepo ppRepo;

    @PostMapping("/get-chairs-in-pp")
    public Collection<PInChair> getAllChairsInPiece(@RequestBody PieceOnProgram incomingPP) {
        Optional<PieceOnProgram> ppToFind = ppRepo.findById(incomingPP.getId());
        return ppToFind.map(PieceOnProgram::getChairsToFill).orElse(null);
    }

//    @PostMapping("put-player-in-chair")
//    public PInChair putAPlayerInAChair(@RequestBody PlayerPlacer playerPlacer) {
//
//        try {
//            Optional<Player> playerToFind = Optional.ofNullable(playerPlacer.player);
//            Optional<PieceOnProgram> pieceOnProgramToFind = Optional.ofNullable(playerPlacer.pieceOnProgram);
//
//            if (playerToFind.isPresent() && pieceOnProgramToFind.isPresent()) {
//
//            Player foundPlayer = playerToFind.get();
//            PieceOnProgram foundPP = pieceOnProgramToFind.get();
//
//            playerPlacer.pInChair
//
//
//
//            }
//        } catch (
//                Exception error) {
//            error.printStackTrace();
//
//        } return null;
//    }



}
