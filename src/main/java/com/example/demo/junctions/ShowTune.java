package com.example.demo.junctions;


import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.Piece2;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class ShowTune {

    @ManyToOne
    private Piece2 piece;

    @ManyToOne
    private Performance performance;

    private int orderNum;



}
