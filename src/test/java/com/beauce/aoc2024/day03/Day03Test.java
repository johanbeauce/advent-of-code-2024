package com.beauce.aoc2024.day03;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Day03Test {

    List<String> inputExample;
    List<String> inputResult;
    Day03 day03;

    @Nested
    class Part1 {
        @BeforeEach
        void setUp() throws IOException {
            day03 = new Day03();
            inputExample = Files.readAllLines(Path.of("src/main/resources/day03/inputExample.txt"));
            inputResult = Files.readAllLines(Path.of("src/main/resources/day03/inputResult.txt"));
        }

        @Nested
        class Example {


            @Test
            void extract_multiply_instruction_from_input() {
                List<String> multiplyInstruction = day03.extractMultiplyInstruction(inputExample);
                assertThat(multiplyInstruction)
                        .hasSize(4)
                        .isEqualTo(List.of("mul(2,4)", "mul(5,5)", "mul(11,8)", "mul(8,5)"));
            }

            @Test
            void extractNumberForEachOccurrence() {
                assertThat(day03.extractNumberForEachOccurance(inputExample))
                        .isEqualTo(161);
            }
        }

        @Nested
        class Result {
            @Test
            void extractNumberForEachOccurrence() {
                // 32411906 answer is too low, I don't manage several lines
                // 182780583
                assertThat(day03.extractNumberForEachOccurance(inputResult))
                        .isEqualTo(182780583);
            }
        }
    }

    @Nested
    class part2 {
        @BeforeEach
        void setUp() throws IOException {
            day03 = new Day03();
            inputExample = Files.readAllLines(Path.of("src/main/resources/day03/inputExample2.txt"));
            inputResult = Files.readAllLines(Path.of("src/main/resources/day03/inputResult2.txt"));
        }
        @Nested
        class Example {
            @Test
            void remove_all_characters_between_instructions() {
                assertThat(day03.removeCharactersBetweenInstructions(inputExample))
                        .isEqualTo("xmul(2,4)&mul[3,7]!^?mul(8,5))");
            }

            @Test
            void remove_all_characters_from_serveral_don_t() {
                assertThat(day03.removeCharactersBetweenInstructions(List.of("mul(1,1)xxxdon't()xxxmul(2,2)xxxxdon't()xxxxdo()xxxmul(3,3)xxxdon't()xxxxdo()xxxmul(4,4)xxx")))
                        .isEqualTo("mul(1,1)xxxxxxmul(3,3)xxxxxxmul(4,4)xxx");
            }

            @Test
            void extractNumberForEachOccurrence() {
                var result = day03.extractNumberForEachOccurance(List.of(day03.removeCharactersBetweenInstructions(inputExample)));
                assertThat(result)
                        .isEqualTo(48);
            }
        }

        @Nested
        class Result {

            @Test
            void extractNumberForEachOccurrence() {
                // 106784935 too high
                var inputLines = day03.removeCharactersBetweenInstructions(inputResult);

                assertThat(day03.extractNumberForEachOccurance(List.of(inputLines)))
                        .isEqualTo(90772405L);
            }
        }
    }

}