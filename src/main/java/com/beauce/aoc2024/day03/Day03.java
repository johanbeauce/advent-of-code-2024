package com.beauce.aoc2024.day03;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 {
    public List<String> extractMultiplyInstruction(List<String> inputLines) {
        return inputLines.stream()
                .flatMap(inputLine -> getMuliplyOccurrence(inputLine).stream())
                .toList();
    }

    private List<String> getMuliplyOccurrence(String input) {
        Pattern pattern =  Pattern.compile("mul\\((\\d{1,3}),(\\d{1,3})\\)");
        Matcher matcher = pattern.matcher(input);

        List<String> matches = new ArrayList<>();
        while (matcher.find()) {
            matches.add(matcher.group());
        }
        return matches;
    }

    public long extractNumberForEachOccurance(List<String> inputLines) {
        return extractMultiplyInstruction(inputLines).stream()
                .mapToLong(this::extractNumberAndMultiply)
                .sum();
    }

    private long extractNumberAndMultiply(String mulInstruction) {
        var firstNumber = Long.parseLong(mulInstruction.split(",")[0].substring(4));
        var secondNumber = Long.parseLong(mulInstruction.split(",")[1].substring(0, mulInstruction.split(",")[1].length() - 1));
        return firstNumber * secondNumber;
    }

    public String removeCharactersBetweenInstructions(List<String> inputLines) {
        var inputLine = String.join("", inputLines);

        var inputLineSize = 0;
        while(inputLineSize != inputLine.length()) {
            inputLineSize = inputLine.length();
            inputLine = removeCharactersBetweenInstructions(inputLine);
        }
        return inputLine;
    }

    private String removeCharactersBetweenInstructions(String inputLine) {
        String regex = "don't\\(\\).*?do\\(\\)";
        return inputLine.replaceAll(regex, "").trim();
    }
}
