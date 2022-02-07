package com.example.demo.junctions;


import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.Show;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;

import javax.persistence.*;

@Entity
public class ShowTune implements Comparable<ShowTune>  {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece2 piece;

    @ManyToOne
    private Show show;

    private int orderNum;

    public ShowTune() {
    }

    public ShowTune(Piece2 piece, Show show) {
        this.piece = piece;
        this.show = show;
    }

    public ShowTune(Piece2 piece, Show show, int orderNum) {
        this.piece = piece;
        this.show = show;
        this.orderNum = orderNum;
    }

    public void setPiece(Piece2 piece) {
        this.piece = piece;
    }

    public void setShow(Show show) {
        this.show = show;
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

    public Show getShow() {
        return show;
    }

    public int getOrderNum() {
        return orderNum;
    }

    @Override
    public int compareTo(ShowTune other) {
        if (orderNum > other.getOrderNum()) {
            return 1;
        }
        return 0;
    }
}
