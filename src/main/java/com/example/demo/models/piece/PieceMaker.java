package com.example.demo.models.piece;

import com.example.demo.models.piece.Piece;
import com.example.demo.models.piece.PieceBuilder;

public class PieceMaker {

    public static Piece makeFrom(Piece otherPiece) {

        return new PieceBuilder()
                .prefix(otherPiece.getPrefix())
                .libNumber(otherPiece.getLibNumber())
                .suffix(otherPiece.getSuffix())
                .composerName(otherPiece.getComposerName())
                .arranger(otherPiece.getArranger())
                .title(otherPiece.getTitle())
                .otherName(otherPiece.getOtherName())
                .publisher(otherPiece.getPublisher())
                .duration(otherPiece.getDuration())
                .instrumentation(otherPiece.getInstrumentation())
                .vocalistSoloist(otherPiece.getVocalistSoloist())
                .percBreakdown(otherPiece.getPercBreakdown())
                .notes(otherPiece.getNotes())
                .status(otherPiece.getStatus())
                .sign(otherPiece.getSign())
                .updated(otherPiece.getUpdated())
                .orchestration(otherPiece.getOrchestration())
                .build();
    }

    public static Piece2 makeUsing(Piece2 otherPiece) {

        return new PieceBuilder()
                .prefix(otherPiece.getPrefix())
                .libNumber(otherPiece.getLibNumber())
                .suffix(otherPiece.getSuffix())
                .composerName(otherPiece.getComposerName())
                .arranger(otherPiece.getArranger())
                .title(otherPiece.getTitle())
                .otherName(otherPiece.getOtherName())
                .publisher(otherPiece.getPublisher())
                .duration(otherPiece.getDuration())
                .instrumentation(otherPiece.getInstrumentation())
                .vocalistSoloist(otherPiece.getVocalistSoloist())
                .percBreakdown(otherPiece.getPercBreakdown())
                .notes(otherPiece.getNotes())
                .status(otherPiece.getStatus())
                .sign(otherPiece.getSign())
                .updated(otherPiece.getUpdated())
                .scoreLines(otherPiece.getEmptyChairs())
                .buildNew();

    }

}
