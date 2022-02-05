package com.example.demo.models.performance;

import java.util.Optional;

public class PerformanceMaker {

    public static Performance makeFrom(PerformanceAdder adder) {

        return new PerformanceBuilder()
                .title(adder.performance.getTitle())
                .performanceDates(adder.performance.getPerformanceDates())
                .rehearsalDates(adder.performance.getRehearsalDates())
                .numberOfServices(adder.performance.getNumberOfServices())
                .notes(adder.performance.getNotes())
                .build();
    }

    public static Show makeUsing(Show show) {
        return new PerformanceBuilder()
                .title(show.getTitle())
                .performanceDates(show.getPerformanceDates())
                .rehearsalDates(show.getRehearsalDates())
                .numberOfServices(show.getNumberOfServices())
                .notes(show.getNotes())
                .buildNew();
    }


}
