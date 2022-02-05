package com.example.demo.models.showTunePlayer;


import com.example.demo.enums.Part;
import com.example.demo.junctions.PInChair;
import com.example.demo.junctions.ShowTune;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
public class PlayerInChair implements Comparable<PlayerInChair>{

    @Id
    @GeneratedValue
    private Long id;

    private Part part;
    private int rank;

    @ManyToOne
    private Player player;

    @ElementCollection
    private List<Part> parts = new ArrayList<>();

    @ManyToOne
    private ShowTune pieceOnProgram;


    public PlayerInChair() {
    }

    public PlayerInChair(Part part, int rank) {
        parts.add(part);
        this.part = parts.get(0);
        this.rank = rank;
    }

    public PlayerInChair(ShowTune pieceOnProgram, Part part, int rank) {
        this.pieceOnProgram = pieceOnProgram;
        parts.add(part);
        this.part = parts.get(0);
        this.rank = rank;
    }

    public PlayerInChair(ShowTune pieceOnProgram, Part part, int rank, Part part2) {
        this.pieceOnProgram = pieceOnProgram;
        parts.add(part);
        parts.add(part2);
        this.part = parts.get(0);
        this.rank = rank;
    }

    public PlayerInChair(ShowTune pieceOnProgram, Part part, int rank, Part part2, Part part3) {
        this.pieceOnProgram = pieceOnProgram;
        parts.add(part);
        parts.add(part2);
        parts.add(part3);
        this.part = parts.get(0);
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

    public void setParts(List<Part> parts) {
        this.parts = parts;
    }

    public void setPieceOnProgram(ShowTune pieceOnProgram) {
        this.pieceOnProgram = pieceOnProgram;
    }

    public Long getId() {
        return id;
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

    public List<Part> getParts() {
        return parts;
    }

    public ShowTune getPieceOnProgram() {
        return pieceOnProgram;
    }

    public void addPart(Part part) {
        parts.add(part);
    }

    @Override
    public int compareTo(PlayerInChair other) {
        if (part.compare(other.getPart()) != 0) {
            return part.compare(other.getPart());
        } else if (rank > other.getRank()) {
            return 1;
        } else {
            return -1;
        }
    }

}
