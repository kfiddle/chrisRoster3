package com.example.demo.models.performance;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.piece.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PerformanceAdder {

    public Performance performance;
    public List<Piece> piecesToAdd;

    public boolean piecesSubmitted() {
        return piecesToAdd != null;
    }

    public List<PieceOnProgram> mappedPiecesToShow() {
        List<PieceOnProgram> mappedPiecesToReturn = new ArrayList<>();
        for (Piece piece : piecesToAdd) {
            PieceOnProgram pieceOnShow = new PieceOnProgram(piece);
            mappedPiecesToReturn.add(pieceOnShow);
        } return mappedPiecesToReturn;
    }

}
