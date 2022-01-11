package com.example.demo.controllers;


import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.NumbOnPart;
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

}
