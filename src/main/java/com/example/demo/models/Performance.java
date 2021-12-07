package com.example.demo.models;

import com.example.demo.junctions.PieceOnProgram;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
public class Performance implements Comparable<Performance> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ElementCollection
    private List<DateTime> performanceDateTimes;

    @ElementCollection
    private List<DateTime> rehearsalDateTimes;

    private int numberOfServices;

    private String notes;

    @OneToMany
    private List<PieceOnProgram> program;

    public Performance() {
        program = new ArrayList<>();
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDateTimes(List<DateTime> performanceDateTimes) {
        this.performanceDateTimes = performanceDateTimes;
    }

    public void setProgram(List<PieceOnProgram> performancePieces) {
        this.program = performancePieces;
    }

    public void setPerformanceDateTimes(List<DateTime> performanceDateTimes) {
        this.performanceDateTimes = performanceDateTimes;
    }

    public void setRehearsalDateTimes(List<DateTime> rehearsalDateTimes) {
        this.rehearsalDateTimes = rehearsalDateTimes;
    }

    public void setNumberOfServices(int numberOfServices) {
        this.numberOfServices = numberOfServices;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<DateTime> getPerformanceDateTimes() {
        return performanceDateTimes;
    }

    public List<DateTime> getRehearsalDateTimes() {
        return rehearsalDateTimes;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public String getNotes() {
        return notes;
    }

    public List<PieceOnProgram> getProgram() {
        return program;
    }

    public void setAllProps(Performance incoming) {
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getPerformanceDateTimes() != null) {
            performanceDateTimes = incoming.getPerformanceDateTimes();
        }
        if (incoming.getRehearsalDateTimes() != null) {
            rehearsalDateTimes = incoming.getRehearsalDateTimes();
        }
        if (incoming.getNumberOfServices() > 0) {
            numberOfServices = incoming.getNumberOfServices();
        }
        if (incoming.getNotes() != null) {
            notes = incoming.getNotes();
        }
        if (incoming.getProgram() != null) {
            program = incoming.getProgram();
        }

    }

    @Override
    public int compareTo(Performance next) {
        return performanceDateTimes.get(0).getDate().compareTo(next.performanceDateTimes.get(0).getDate());

    }
}

