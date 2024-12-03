package com.beauce.aoc2024.day02;

import java.util.List;

public class Day02 {
    public List<Report> getReports(List<String> input) {
        return input.stream()
                .map(Report::new)
                .toList();
    }

    public long countValid(List<Report> reports) {
        return reports.stream()
                .filter(Report::isValid)
                .count();
    }

    public long coundValidByToleringOneBadLevel(List<Report> reports) {
        return reports.stream()
                .filter(Report::isValidByToleratingOneBadLevel)
                .count();
    }
}
