package com.example.demo.models.performance;


import com.example.demo.junctions.ShowTune;
import com.example.demo.models.DateTime;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Show {


    @Id
    @GeneratedValue
    private Long id;

    private String title;

    @ElementCollection
    private List<ShowTune> showTunes;

    @ElementCollection
    private List<DateTime> performanceDates = new ArrayList<>();

    @ElementCollection
    private List<DateTime> rehearsalDates = new ArrayList<>();

    private int numberOfServices;

    private String notes;

    public Show() {
    }


    public Show(PerformanceBuilder performanceBuilder) {
        this.title = performanceBuilder.title;
        this.showTunes = performanceBuilder.showTunes;
        this.performanceDates = performanceBuilder.performanceDates;
        this.rehearsalDates = performanceBuilder.rehearsalDates;
        this.numberOfServices = performanceBuilder.numberOfServices;
        this.notes = performanceBuilder.notes;

    }
}
