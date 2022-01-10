package com.example.demo.junctions;

import com.example.demo.enums.Part;
import com.example.demo.models.player.Player;

import javax.persistence.*;


@Embeddable

public class PInChair {

    private Part part;
    private int rank;

    @ManyToOne
    private Player player;

    public PInChair() {
    }

    public PInChair(Part part, int rank) {
        this.part = part;
        this.rank = rank;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Part getPart() {
        return part;
    }

    public int getRank() {
        return rank;
    }

    public Player getPlayer() {
        return player;
    }
}
