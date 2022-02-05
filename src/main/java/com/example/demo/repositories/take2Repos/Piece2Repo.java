package com.example.demo.repositories.take2Repos;


import com.example.demo.models.piece.Piece2;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface Piece2Repo extends CrudRepository<Piece2, Long> {

    boolean existsByTitle(String title);

    boolean existsByTitleAndComposerName(String title, String composerName);

    Collection<Piece2> findAllBy(Sort by);
}
