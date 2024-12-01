package com.beauce.aoc2024.day01;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day01Test {

    List<String> input;
    Day01 day01;

    @BeforeEach
    void setUp() throws IOException {
        day01 = new Day01();
        input = Files.readAllLines(Path.of("src/main/resources/day01/input.txt"));
    }

    @Test
    void verify_file_reader_is_ready() {
        assertThat(input)
                .hasSize(3)
                .containsExactly("line 1", "line 2", "line 3");
    }
}