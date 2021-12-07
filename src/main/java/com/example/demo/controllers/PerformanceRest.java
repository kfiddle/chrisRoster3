package com.example.demo.controllers;


import com.example.demo.models.Performance;
import com.example.demo.repositories.PerformanceRepo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@CrossOrigin
@RestController
public class PerformanceRest {

    @Resource
    PerformanceRepo performanceRepo;


    @RequestMapping("/get-all-performances")
    public Collection<Performance> getAllPerformances() {
        List<Performance> sortedPerformances = new ArrayList<>((Collection<Performance>) performanceRepo.findAll());
        Collections.sort(sortedPerformances);
        return sortedPerformances;
    }

}
