package com.example.demo.models.performance;

import java.util.Optional;

public class PerformanceMaker {

    public static Performance makeFrom(PerformanceAdder adder) {

        return new PerformanceBuilder()
                .title(adder.performance.getTitle())
                .program(adder.showTunes)
                .performanceDates(adder.performance.getPerformanceDates())
                .rehearsalDates(adder.performance.getRehearsalDates())
                .numberOfServices(adder.performance.getNumberOfServices())
                .notes(adder.performance.getNotes())
                .build();

    }
//                .program(adder.mappedPiecesToShow())

}
