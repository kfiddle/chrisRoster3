package com.example.demo.controllers;

import com.example.demo.enums.Part;
import com.example.demo.enums.Type;
import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.player.Player;
import com.example.demo.models.player.PlayerMaker;
import com.example.demo.models.player.RosterSpot;
import com.example.demo.repositories.PieceOnProgramRepo;
import com.example.demo.repositories.PlayerRepo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@CrossOrigin
@RestController
public class PlayerRest {


    @Resource
    PlayerRepo playerRepo;

    @Resource
    PieceOnProgramRepo ppRepo;

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
        List<Player> playersToSendBack = (List<Player>) playerRepo.findAllByType(Type.CONTRACTED);
        Collections.sort(playersToSendBack);

        return playersToSendBack;
    }

    @PostMapping("/add-player")
    public Player addPlayerToDatabase(@RequestBody Player incomingPlayer) throws IOException {

        try {
            if (playerRepo.existsByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName())) {
                return playerRepo.findByFirstNameAreaAndLastName(incomingPlayer.getFirstNameArea(), incomingPlayer.getLastName());
            } else {
                playerRepo.save(PlayerMaker.makeFrom(incomingPlayer));
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

    @PostMapping("/get-possible-players")
    public List<Player> getPossiblePlayersForAChair(@RequestBody RosterSpot incomingSpot) {

        try {

            List<Player> playersToSend = new ArrayList<>();


            Optional<PieceOnProgram> ppToFind = ppRepo.findById(incomingSpot.pp.getId());
            if (ppToFind.isPresent()) {
                PieceOnProgram foundPP = ppToFind.get();

                PInChair chairToCheck = foundPP.getChairsToFill().get(incomingSpot.indexOfChair);

                for (Player player : playerRepo.findAll()) {
                    if (!foundPP.playerIsOnThis(player) && player.canPlayerSitHere(chairToCheck)) {
                        playersToSend.add(player);
                    }
                }
            }
            Collections.sort(playersToSend);
            return playersToSend;


        } catch (Exception error) {
            error.printStackTrace();
        }
        return null;
    }
}
