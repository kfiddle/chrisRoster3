package com.example.demo.controllers;

import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;

@CrossOrigin
@RestController
public class PlayerRest {


    @Resource
    PlayerRepo playerRepo;

    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {
        return (Collection<Player>) playerRepo.findAll();
    }

    @RequestMapping("get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {
        return playerRepo.findAllByType(Type.CONTRACTED);
    }

    @RequestMapping("get-all-subs")
    public Collection<Player> getAllSubs() {
        return playerRepo.findAllByType(Type.SUB);
    }

}
