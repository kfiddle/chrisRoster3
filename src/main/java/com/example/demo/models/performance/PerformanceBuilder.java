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



public class PerformanceBuilder {


    public String title;

    @OneToMany
    public List<PieceOnProgram> program;

    @ElementCollection
    public List<DateTime> performanceDates;

    @ElementCollection
    public List<DateTime> rehearsalDates;

    public int numberOfServices;

    public String notes;

    public PerformanceBuilder() {
        program = new ArrayList<>();
        performanceDates = new ArrayList<>();
        rehearsalDates = new ArrayList<>();
    }

    public PerformanceBuilder title(String title) {
        if (title != null) {
            this.title = title;
        }
        return this;
    }

    //    public PerformanceBuilder program(List<PieceOnProgram> program) {
//        if (program != null) {
//            this.program = program;
//        }
//        return this;
//    }

    public PerformanceBuilder program(List<Piece> program) {
        if (program != null) {
            for (Piece piece : program) {
                PieceOnProgram pieceToAdd = new PieceOnProgram(piece);
                this.program.add(pieceToAdd);
            }
        }
        return this;
    }

    public PerformanceBuilder withDate(DateTime primaryDate) {
        if (primaryDate != null) {
            performanceDates.add(primaryDate);
        }
        return this;
    }

    public PerformanceBuilder performanceDates(List<DateTime> performanceDates) {
        if (performanceDates != null) {
            this.performanceDates = performanceDates;
        }
        return this;
    }

    public PerformanceBuilder rehearsalDates(List<DateTime> rehearsalDates) {
        if (rehearsalDates != null) {
            this.rehearsalDates = rehearsalDates;
        }
        return this;
    }

    public PerformanceBuilder numberOfServices(int numberOfServices) {
        if (numberOfServices > 0) {
            this.numberOfServices = numberOfServices;
        }
        return this;
    }

    public PerformanceBuilder notes(String notes) {
        if (notes != null) {
            this.notes = notes;
        }
        return this;
    }

    public PerformanceBuilder build() {
        return this;
    }


}
