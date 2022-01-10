package com.example.demo.models.performance;

import com.example.demo.junctions.PieceOnProgram;
import com.example.demo.models.DateTime;
import com.example.demo.models.piece.Piece;

import javax.annotation.Resource;
import javax.persistence.ElementCollection;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


public class PerformanceBuilder {


    public String title;

//    @OneToMany
//    public List<PieceOnProgram> program = new ArrayList<>();

    public List<Long> showTunesIds;

//    @ElementCollection
    public List<DateTime> performanceDates = new ArrayList<>();;

//    @ElementCollection
    public List<DateTime> rehearsalDates = new ArrayList<>();;

    public int numberOfServices;

    public String notes;

    public PerformanceBuilder() {
    }

    public PerformanceBuilder title(String title) {
        Optional<String> titleCheck = Optional.ofNullable(title);
        titleCheck.ifPresent(gottenTitle -> this.title = gottenTitle);
        return this;
    }

//    public PerformanceBuilder program(List<PieceOnProgram> program) {
//        Optional<List<PieceOnProgram>> programOpt = Optional.ofNullable(program);
//        programOpt.ifPresent(gotten -> this.program = gotten);
//        return this;
//    }

    public PerformanceBuilder showTunesIds(List<Long> showTunesIds) {
        Optional<List<Long>> showTunesOpt = Optional.ofNullable(showTunesIds);
        showTunesOpt.ifPresent(gotten -> this.showTunesIds = gotten);
        return this;
    }

    public PerformanceBuilder withDate(DateTime primaryDate) {
        if (primaryDate != null) {
            performanceDates.add(primaryDate);
        }
        return this;
    }

    public PerformanceBuilder performanceDates(List<DateTime> performanceDates) {
        Optional<List<DateTime>> datesOpt = Optional.ofNullable(performanceDates);
        datesOpt.ifPresent(gotten -> this.performanceDates = gotten);
        return this;
    }

    public PerformanceBuilder rehearsalDates(List<DateTime> rehearsalDates) {
        Optional<List<DateTime>> datesOpt = Optional.ofNullable(rehearsalDates);
        datesOpt.ifPresent(gotten -> this.rehearsalDates = gotten);
        return this;
    }

    public PerformanceBuilder numberOfServices(int numberOfServices) {
        if (numberOfServices > 0) {
            this.numberOfServices = numberOfServices;
        }
        return this;
    }

    public PerformanceBuilder notes(String notes) {
        Optional<String> notesOpt = Optional.ofNullable(notes);
        notesOpt.ifPresent(gotten -> this.notes = gotten);
        return this;
    }

    public Performance build() {
        return new Performance(this);
    }


}
