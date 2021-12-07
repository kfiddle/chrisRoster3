package com.example.demo.repositories;

import com.example.demo.models.Piece;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PieceRepo extends CrudRepository<Piece, Long> {

    boolean existsByTitle(String title);

    boolean existsByTitleAndComposerName(String title, String composerName);

    Collection<Piece> findAllBy(Sort by);

}

