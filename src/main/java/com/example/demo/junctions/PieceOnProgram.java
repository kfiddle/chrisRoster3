package com.example.demo.junctions;


import com.example.demo.models.NumbOnPart;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.player.Player;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

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
    private Collection<PInChair> chairsToFill;

    public PieceOnProgram() {
    }

    public PieceOnProgram(Piece piece, Performance performance) {
        this.piece = piece;
        this.performance = performance;
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

    public Collection<PInChair> getChairsToFill() {
        return chairsToFill;
    }

    public void setChairsToFill(Collection<PInChair> chairsToFill) {
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

    @Override
    public int compareTo(PieceOnProgram other) {
        if (orderNum > other.getOrderNum()) {
            return 1;
        }
        return 0;
    }
}
