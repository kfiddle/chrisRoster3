package com.example.demo.controllers;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.models.Player;
import com.example.demo.models.PlayerMaker;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
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
    }

    @PostMapping("/add-player")
    public Player addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

            } else {
                Player playerToAdd = PlayerMaker.makeFrom(incomingPlayer);
                if (playerToAdd.getParts() != null) {
                    for (Part part : playerToAdd.getParts()) {
                        System.out.println(part.toString());
                    }
                }

                playerRepo.save(playerToAdd);
                System.out.println(playerToAdd.getFirstNameArea() + "   " + playerToAdd.getLastName());
                System.out.println(playerToAdd.getType() + "   " + playerToAdd.getRank());
            }
        } catch (Exception error) {
            error.printStackTrace();
        }
        return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());

    }

    @RequestMapping("/get-all-sub-players")
    public Collection<Player> getAllSubs() {
        return playerRepo.findAllByType(Type.SUB);
    }

    @RequestMapping("/subs/{incomingPart}")
    public Collection<Player> getSubsOfInstrument(@PathVariable String incomingPart) {
        System.out.println(incomingPart);
        Part partToFind = Part.ofPartName(incomingPart);
        Collection<Player> playersToSend = new ArrayList<>();
        for (Player player : playerRepo.findAllByType(Type.SUB)) {
            for (Part part : player.getParts()) {
                if (part.equals(partToFind)) {
                    playersToSend.add(player);
                }
            }
        }
        return playersToSend;
    }

}
