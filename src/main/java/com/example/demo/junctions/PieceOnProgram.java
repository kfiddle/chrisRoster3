package com.example.demo.junctions;


import com.example.demo.models.NumbOnPart;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.*;

@Entity
public class PieceOnProgram implements Comparable<PieceOnProgram> {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece piece;

    @ManyToOne
    private Performance performance;

    private int orderNum;

    @ElementCollection
    private List<PInChair> chairsToFill = new ArrayList<>();

    public PieceOnProgram() {
    }

    public PieceOnProgram(Piece piece, Performance performance) {
        this.piece = piece;
        this.performance = performance;

        if (piece.getOrchestration() != null) {
            makeSomeEmptyChairs();
        }
    }

    public Long getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public Performance getPerformance() {
        return performance;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public List<PInChair> getChairsToFill() {
        return chairsToFill;
    }

    public void setChairsToFill(List<PInChair> chairsToFill) {
        this.chairsToFill = chairsToFill;
    }


    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public void makeSomeEmptyChairs() {

        for (NumbOnPart numbOnPart : piece.getOrchestration()) {
            for (int j = 1; j <= numbOnPart.getNumber(); j++) {
                PInChair chairToFill = new PInChair(numbOnPart.getPart(), j);
                chairsToFill.add(chairToFill);
            }
        }
        this.setChairsToFill(chairsToFill);
    }

    public boolean playerIsOnThis(Player player) {
        boolean flag = false;
        for (PInChair pInChair : chairsToFill) {
            if (pInChair.getPlayer().equals(player)) {
                flag = true;
            }
        } return flag;
    }

    @Override
    public int compareTo(PieceOnProgram other) {
        if (orderNum > other.getOrderNum()) {
            return 1;
        }
        return 0;
    }
}
