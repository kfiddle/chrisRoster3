package com.example.demo.junctions;


import com.example.demo.models.Performance;
import com.example.demo.models.Piece;

import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Embeddable
public class PieceOnProgram {

    @ManyToOne
    private Piece piece;

    @ElementCollection
    private Collection<PInChair> chairsToFill;

    public PieceOnProgram() {}

    public PieceOnProgram(Piece piece) {
        this.piece = piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
