package com.example.demo.repositories.take2Repos;

import com.example.demo.junctions.ShowTune;
import com.example.demo.models.performance.Show;
import com.example.demo.models.piece.Piece2;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ShowTuneRepo extends CrudRepository<ShowTune, Long> {

    Collection<ShowTune> findAllByShow(Show incomingShow);

    boolean existsByPiece2(Piece2 pieceToAttachOrch);

    Collection<ShowTune> findAllByPiece2(Piece2 piece2);
}
