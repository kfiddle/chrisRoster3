package com.example.demo.junctions;

import com.example.demo.enums.Part;
import com.example.demo.models.PartsList;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Embeddable

public class PInChair implements Comparable<PInChair> {

    private Part part;
    private int rank;

    private Part part2;
    private Part part3;

    @ManyToOne
    private Player player;

    public PInChair() {
    }

    public PInChair(Part part, int rank) {
        this.part = part;
        this.rank = rank;
    }

    public PInChair(Part part, int rank, Part part2) {
        this.part = part;
        this.rank = rank;
        this.part2 = part2;
    }

    public PInChair(Part part, int rank, Part part2, Part part3) {
        this.part = part;
        this.rank = rank;
        this.part2 = part2;
        this.part3 = part3;
    }

    public void setPart(Part part) {
        this.part = part;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setPart2(Part part2) {
        this.part2 = part2;
    }

    public void setPart3(Part part3) {
        this.part3 = part3;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public boolean hasThisPlayer(Player incomingPlayer) {
        return player != null && player.equals(incomingPlayer);
    }

    public Part getPart() {
        return part;
    }

    public int getRank() {
        return rank;
    }

    public Part getPart2() {
        return part2;
    }

    public Part getPart3() {
        return part3;
    }

    public Player getPlayer() {
        return player;
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
