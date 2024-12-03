package com.beauce.aoc2024.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    List<String> inputExample;
    List<String> input;

    Day01 day01;
    private BothList bothList;

    @BeforeEach
    void setUp() throws IOException {
        day01 = new Day01();
        inputExample = Files.readAllLines(Path.of("src/main/resources/day01/inputExample.txt"));
        input = Files.readAllLines(Path.of("src/main/resources/day01/inputResult.txt"));
    }

    @Nested
    class part_1 {

        @Nested
        class Example {
            @Nested
            class When_list_is_split_in_2_parts {

                @BeforeEach
                void setUp() {
                    bothList = day01.getBothList(inputExample);
                }

                @Test
                void both_list_has_6_elements() {
                    assertThat(bothList.leftList())
                            .hasSize(6);
                    assertThat(bothList.rightList())
                            .hasSize(6);
                }

                @Nested
                class When_list_is_sorted {

                    private BothList bothListSorted;

                    @BeforeEach
                    void setUp() {
                        bothListSorted = bothList.sort();
                    }

                    @Test
                    void each_element_of_both_list_are_sorted() {
                        assertThat(bothListSorted.leftList())
                                .hasSize(6)
                                .containsExactly(1, 2, 3, 3, 3, 4);
                        assertThat(bothListSorted.rightList())
                                .hasSize(6)
                                .containsExactly(3, 3, 3, 4, 5, 9);
                    }

                    @Nested
                    class When_diff_list_is_generated {

                        private List<Integer> diffList;

                        @BeforeEach
                        void setUp() {
                            diffList = bothListSorted.getDiffList();
                        }

                        @Test
                        void diff_list_is_generated() {
                            assertThat(diffList)
                                    .hasSize(6)
                                    .containsExactly(2, 1, 0, 1, 2, 5);
                        }

                        @Nested
                        class When_total_is_calculated {

                            private int total;

                            @BeforeEach
                            void setUp() {
                                total = day01.getTotal(diffList);
                            }

                            @Test
                            void total_is_11() {
                                assertThat(total)
                                        .isEqualTo(11);
                            }
                        }
                    }
                }
            }
        }

        @Nested
        class Result {
            @Test
            void output() {
                var diffList = day01.getBothList(input)
                        .sort()
                        .getDiffList();

                assertThat(day01.getTotal(diffList))
                        .isEqualTo(2375403);
            }
        }
    }

    @Nested
    class part_2 {

        @Nested
        class Example {

            @Test
            void get_list_with_number_of_occurrence_in_the_second_list() {
                var multipliedNumberList = day01.getBothList(inputExample)
                        .getListMultiplyNumberOfOccurrenceInTheSecondList();
                assertThat(multipliedNumberList)
                        .containsExactly(9L, 4L, 0L, 0L, 9L, 9L);
            }

            @Test
            void get_sum() {
                var multipliedNumberList = day01.getBothList(inputExample)
                        .getListMultiplyNumberOfOccurrenceInTheSecondList();
                assertThat(day01.getMultiplyTotal(multipliedNumberList))
                        .isEqualTo(31L);
            }
        }

        @Nested
        class Result {

            @Test
            void output() {
                var multipliedNumberList = day01.getBothList(input)
                        .getListMultiplyNumberOfOccurrenceInTheSecondList();
                assertThat(day01.getMultiplyTotal(multipliedNumberList))
                        .isEqualTo(23082277L);
            }
        }
    }
}