package com.example.demo.junctions;


import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.Show;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;

import javax.persistence.*;

@Entity
public class ShowTune {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece2 piece;

    @ManyToOne
    private Show performance;

    private int orderNum;

    public ShowTune() {
    }

    public ShowTune(Piece2 piece, Show performance) {
        this.piece = piece;
        this.performance = performance;
    }

    public ShowTune(Piece2 piece, Show performance, int orderNum) {
        this.piece = piece;
        this.performance = performance;
        this.orderNum = orderNum;
    }

    public void setPiece(Piece2 piece) {
        this.piece = piece;
    }

    public void setPerformance(Show performance) {
        this.performance = performance;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public Long getId() {
        return id;
    }

    public Piece2 getPiece() {
        return piece;
    }

    public Show getPerformance() {
        return performance;
    }

    public int getOrderNum() {
        return orderNum;
    }
}
