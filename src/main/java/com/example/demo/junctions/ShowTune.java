package com.example.demo.junctions;


import com.example.demo.models.performance.Performance;
import com.example.demo.models.performance.Show;
import com.example.demo.models.piece.EmptyChair;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;
import com.example.demo.models.showTunePlayer.PlayerInChair;
import com.example.demo.models.showTunePlayer.PlayerInChairBuilder;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
public class ShowTune implements Comparable<ShowTune>  {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece2 piece2;

    @ManyToOne
    private Show show;

    private int orderNum;

    public ShowTune() {
    }

    public ShowTune(Piece2 piece2, Show show) {
        this.piece2 = piece2;
        this.show = show;
    }

    public ShowTune(Piece2 piece2, Show show, int orderNum) {
        this.piece2 = piece2;
        this.show = show;
        this.orderNum = orderNum;
    }

    public void setPiece2(Piece2 piece2) {
        this.piece2 = piece2;
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

    public Piece2 getPiece2() {
        return piece2;
    }

    public Show getShow() {
        return show;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public Collection<PlayerInChair> makeSomeEmptyChairs() {
        Collection<PlayerInChair> chairsToReturn = new ArrayList<>();
        for (EmptyChair emptyChair : piece2.getEmptyChairs()) {
            PlayerInChair playerInChair = new PlayerInChairBuilder()
                    .primaryPart(emptyChair.getPrimaryPart())
                    .rank(emptyChair.getRank())
                    .secondaryPart(emptyChair.getSecondaryPart())
                    .thirdPart(emptyChair.getThirdPart())
                    .build();
            chairsToReturn.add(playerInChair);
        }
        return chairsToReturn;
    }

    @Override
    public int compareTo(ShowTune other) {
        if (orderNum > other.getOrderNum()) {
            return 1;
        }
        return 0;
    }
}
