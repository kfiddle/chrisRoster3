package com.example.demo.junctions;

import com.example.demo.enums.Part;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Embeddable

public class PInChair implements Comparable<PInChair> {

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

    public boolean hasThisPlayer(Player incomingPlayer) {
        return player != null && player.equals(incomingPlayer);
    }

    @Override
    public int compareTo(PInChair other) {
        if (part.compare(other.getPart()) != 0) {
            return part.compare(other.getPart());
        } else if (rank > other.getRank()) {
            return 1;
        } else {
            return -1;
        }
    }
}
