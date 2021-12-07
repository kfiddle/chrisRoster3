package com.example.demo.controllers;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class PlayerRest {


    @Resource
    PlayerRepo playerRepo;

    @RequestMapping("/get-all-players")
    public Collection<Player> getAllPlayers() {
        return (Collection<Player>) playerRepo.findAll();
    }

    @RequestMapping("/get-all-parts")
    public Collection<String> getAllParts() {
        Collection<String> parts = new ArrayList<>();
        for (Part part : Part.values()) {
            parts.add(part.toString());
        }
        return parts;
    }

    @RequestMapping("/get-all-contracted-players")
    public Collection<Player> getAllContractedPlayers() {

        return playerRepo.findAllByType(Type.CONTRACTED);

//        List<Player> playersToReturn = new ArrayList<>();
//        Collection<Player> contracted = playerRepo.findAllByType(Type.CONTRACTED);
//
//        for (Part part : Part.values()) {
//            List<Player> sectionList = new ArrayList<>();
//            for (Player player : contracted) {
//                if (player.getParts().get(0).equals(part)) {
//                    sectionList.add(player);
//                }
//            }
//            Collections.sort(sectionList);
//            playersToReturn.addAll(sectionList);
//        }
//
//        for (Player player : playersToReturn) {
//            System.out.println(player.getLastName() + "   " + player.getRank());
//        }
//        return playersToReturn;
    }

    @RequestMapping("get-all-subs")
    public Collection<Player> getAllSubs() {
        return playerRepo.findAllByType(Type.SUB);
    }

}
