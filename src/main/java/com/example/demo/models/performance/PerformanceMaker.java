package com.example.demo.models.performance;

public class PerformanceMaker {

    public static Performance makeFrom(Performance otherPerformance) {

        return new Performance(new PerformanceBuilder()
                .title(otherPerformance.getTitle())
                .performanceDates(otherPerformance.getPerformanceDates())
                .rehearsalDates(otherPerformance.getRehearsalDates())
                .numberOfServices(otherPerformance.getNumberOfServices())
                .notes(otherPerformance.getNotes())
                .build()
        );
    }

}
