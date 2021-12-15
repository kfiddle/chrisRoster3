package com.example.demo.repositories;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.performance.Performance;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface PieceOnProgramRepo extends CrudRepository<PieceOnProgram, Long> {

}
