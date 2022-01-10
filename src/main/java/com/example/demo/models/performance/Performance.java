package com.example.demo.models.performance;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.DateTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Performance implements Comparable<Performance> {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "performance")
    private List<PieceOnProgram> program = new ArrayList<>();

    @ElementCollection
    private List<DateTime> performanceDates = new ArrayList<>();

    @ElementCollection
    private List<DateTime> rehearsalDates = new ArrayList<>();

    private int numberOfServices;

    private String notes;

    public Performance() {
    }

    public Performance(PerformanceBuilder performanceBuilder) {
        this.title = performanceBuilder.title;
        this.program = performanceBuilder.program;
        this.performanceDates = performanceBuilder.performanceDates;
        this.rehearsalDates = performanceBuilder.rehearsalDates;
        this.numberOfServices = performanceBuilder.numberOfServices;
        this.notes = performanceBuilder.notes;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setProgram(List<PieceOnProgram> program) {
        this.program = program;
    }

    public void setPerformanceDates(List<DateTime> performanceDates) {
        this.performanceDates = performanceDates;
    }

    public void setRehearsalDates(List<DateTime> rehearsalDates) {
        this.rehearsalDates = rehearsalDates;
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

    public List<PieceOnProgram> getProgram() {
        return program;
    }

    public List<DateTime> getPerformanceDates() {
        return performanceDates;
    }

    public List<DateTime> getRehearsalDates() {
        return rehearsalDates;
    }

    public int getNumberOfServices() {
        return numberOfServices;
    }

    public String getNotes() {
        return notes;
    }

    public void setAllProps(Performance incoming) {
        if (incoming.getTitle() != null) {
            title = incoming.getTitle();
        }
        if (incoming.getPerformanceDates() != null) {
            performanceDates = incoming.getPerformanceDates();
        }
        if (incoming.getRehearsalDates() != null) {
            rehearsalDates = incoming.getRehearsalDates();
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
        return performanceDates.get(0).getDate().compareTo(next.performanceDates.get(0).getDate());

    }
}

