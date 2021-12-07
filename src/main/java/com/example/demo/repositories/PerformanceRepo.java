package com.example.demo.repositories;

import com.example.demo.models.Performance;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PerformanceRepo extends CrudRepository<Performance, Long> {


    Collection<Performance> findAll(Sort sort);

    boolean existsByTitle(String title);

}
