package com.example.demo.junctions;


import com.example.demo.models.Performance;
import com.example.demo.models.Piece;

import javax.persistence.*;
import java.util.Collection;

@Entity
public class PieceOnProgram {

    @Id
    @GeneratedValue
    private Long id;

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

    public Long getId() {
        return id;
    }

    public Piece getPiece() {
        return piece;
    }

    public Collection<PInChair> getChairsToFill() {
        return chairsToFill;
    }
}
