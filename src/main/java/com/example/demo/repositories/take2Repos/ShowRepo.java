package com.example.demo.repositories.take2Repos;

import com.example.demo.models.performance.Show;
import org.springframework.data.repository.CrudRepository;

public interface ShowRepo extends CrudRepository<Show, Long> {
    boolean existsByTitle(String title);

    Show findByTitle(String title);
}
