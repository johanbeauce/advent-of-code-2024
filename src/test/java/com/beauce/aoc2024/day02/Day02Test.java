package com.beauce.aoc2024.day02;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day02Test {

    List<String> inputExample;
    List<String> inputResult;
    Day02 day02;

    @BeforeEach
    void setUp() throws IOException {
        day02 = new Day02();
        inputExample = Files.readAllLines(Path.of("src/main/resources/day02/inputExample.txt"));
        inputResult = Files.readAllLines(Path.of("src/main/resources/day02/input.txt"));
    }

    @Nested
    class part_1 {

        @Nested
        class Example {

            private List<Report> reports;

            @BeforeEach
            void setUp() {
                reports = day02.getReports(inputExample);
            }

            @Test
            void reports_are_increasing() {
                assertThat(reports)
                        .element(0)
                        .extracting(Report::getLevels)
                        .isEqualTo(List.of(7L, 6L, 4L, 2L, 1L));
            }

            @Test
            void level_are_decreasing() {
                assertThat(reports)
                        .element(0)
                        .extracting(Report::areLevelsDecreasing)
                        .isEqualTo(true);
            }

            @Test
            void level_are_decreasing_and_differ_at_least_1_and_at_most_three() {
                assertThat(reports)
                        .extracting(Report::areLevelsDecreasing)
                        .containsExactly(true, false, false, false, false, false);
            }

            @Test
            void level_are_increasing_and_differ_at_least_1_and_at_most_three() {
                assertThat(reports)
                        .extracting(Report::areLevelsIncreasing)
                        .isEqualTo(List.of(false, false, false, false, false, true));
            }

            @Test
            void count_valid_reports() {
                assertThat(day02.countValid(reports))
                        .isEqualTo(2);
            }
        }

        @Nested
        class Result {
            private List<Report> reports;

            @BeforeEach
            void setUp() {
                reports = day02.getReports(inputResult);
            }

            @Test
            void count_valid_reports() {
                assertThat(day02.countValid(reports))
                        .isEqualTo(631);
            }
        }
    }

    @Nested
    class part_2 {
        @Nested
        class Example {
            private List<Report> reports;

            @BeforeEach
            void setUp() {
                reports = day02.getReports(inputExample);
            }

            @Test
            void level_are_decreasing_and_differ_at_least_1_and_at_most_three_by_removing_one_element() {
                assertThat(reports)
                        .extracting(Report::areLevelsDecreasingByRemovingOneElement)
                        .containsExactly(true, false, false, false, true, false);
            }

            @Test
            void level_are_increasing_and_differ_at_least_1_and_at_most_three_by_removing_one_element() {
                assertThat(reports)
                        .extracting(Report::areLevelsIncreasingByRemovingOneElement)
                        .containsExactly(false, false, false, true, false, true);
            }

            @Test
            void count_valid_report_by_tolering_one_bad_level() {
                assertThat(day02.coundValidByToleringOneBadLevel(reports)).isEqualTo(4);
            }
        }

        @Nested
        class Result {
            private List<Report> reports;

            @BeforeEach
            void setUp() {
                reports = day02.getReports(inputResult);
            }

            @Test
            void count_valid_report_by_tolering_one_bad_level() {
                assertThat(day02.coundValidByToleringOneBadLevel(reports)).isEqualTo(665);
            }
        }
    }
}