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
public class PieceOnProgram {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Piece piece;

    @ManyToOne
    private Performance performance;

    @ElementCollection
    private Collection<PInChair> chairsToFill;

    public PieceOnProgram() {
    }

    public PieceOnProgram(Piece piece, Performance performance) {
        this.piece = piece;
        this.performance = performance;
    }

    public void setChairsToFill(Collection<PInChair> chairsToFill) {
        this.chairsToFill = chairsToFill;
    }

    public Collection<PInChair> getChairsToFill() {
        return chairsToFill;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }
}
