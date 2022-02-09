package com.example.demo.models.showTunePlayer;


import com.example.demo.enums.Part;
import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.ShowTune;
import com.example.demo.models.piece.Piece2;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class PlayerInChair implements Comparable<PlayerInChair> {

    @Id
    @GeneratedValue
    private Long id;

    private Part primaryPart;
    private int rank;

    private Part secondaryPart;
    private Part thirdPart;

    @ManyToOne
    private Player player;

    @ManyToOne
    private ShowTune showTune;

    public PlayerInChair() {
    }

    public PlayerInChair(PlayerInChairBuilder playerInChairBuilder) {
        this.primaryPart = playerInChairBuilder.primaryPart;
        this.rank = playerInChairBuilder.rank;
        this.secondaryPart = playerInChairBuilder.secondaryPart;
        this.thirdPart = playerInChairBuilder.thirdPart;
    }

    public void setPrimaryPart(Part primaryPart) {
        this.primaryPart = primaryPart;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setSecondaryPart(Part secondaryPart) {
        this.secondaryPart = secondaryPart;
    }

    public void setThirdPart(Part thirdPart) {
        this.thirdPart = thirdPart;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setShowTune(ShowTune showTune) {
        this.showTune = showTune;
    }

    public Long getId() {
        return id;
    }

    public Part getPrimaryPart() {
        return primaryPart;
    }

    public int getRank() {
        return rank;
    }

    public Part getSecondaryPart() {
        return secondaryPart;
    }

    public Part getThirdPart() {
        return thirdPart;
    }

    public Player getPlayer() {
        return player;
    }

    public ShowTune getShowTune() {
        return showTune;
    }

    @Override
    public int compareTo(PlayerInChair other) {
        if (primaryPart.compare(other.getPrimaryPart()) != 0) {
            return primaryPart.compare(other.getPrimaryPart());
        } else if (rank > other.getRank()) {
            return 1;
        } else {
            return -1;
        }
    }

}
