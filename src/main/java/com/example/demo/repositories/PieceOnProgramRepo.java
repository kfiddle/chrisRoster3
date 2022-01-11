package com.example.demo.repositories;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.performance.Performance;
import com.example.demo.models.piece.Piece;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PieceOnProgramRepo extends CrudRepository<PieceOnProgram, Long> {
    Collection<PieceOnProgram> findAllByPerformance(Performance incomingPerformance);

    boolean existsByPiece(Piece pieceToAttachOrch);

    Collection<PieceOnProgram> findAllByPiece(Piece pieceToAttachOrch);
}
