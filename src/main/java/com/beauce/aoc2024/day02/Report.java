package com.beauce.aoc2024.day02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Report {

    private final List<Long> levels;

    public Report(String input) {
        this.levels = Arrays.stream(input.split(" "))
                .map(Long::parseLong)
                .toList();
    }

    public Report(List<Long> levels) {
        this.levels = levels;
    }

    public List<Long> getLevels() {
        return levels;
    }

    public boolean areLevelsDecreasing() {
        for (int i = 0; i < levels.size() - 1; i++) {
            var number = levels.get(i);
            var nextNumber = levels.get(i + 1);
            if (number <= nextNumber || number - nextNumber > 3) {
                return false;
            }
        }
        return true;
    }

    public boolean areLevelsIncreasing() {
        for (int i = 0; i < levels.size() - 1; i++) {
            var number = levels.get(i);
            var nextNumber = levels.get(i + 1);
            if (number >= nextNumber || nextNumber - number > 3) {
                return false;
            }
        }
        return true;
    }

    public boolean isValid() {
        return areLevelsDecreasing() || areLevelsIncreasing();
    }

    public boolean areLevelsDecreasingByRemovingOneElement() {
        for (int i = 0; i < levels.size() - 1; i++) {
            var number = levels.get(i);
            var nextNumber = levels.get(i + 1);
            if (number <= nextNumber || number - nextNumber > 3) {
                return getNewReport(levels, i).areLevelsDecreasing() ||
                        getNewReport(levels, i + 1).areLevelsDecreasing();
            }
        }
        return true;
    }

    public boolean areLevelsIncreasingByRemovingOneElement() {
        for (int i = 0; i < levels.size() - 1; i++) {
            var number = levels.get(i);
            var nextNumber = levels.get(i + 1);
            if (number >= nextNumber || nextNumber - number > 3) {
                return getNewReport(levels, i).areLevelsIncreasing() ||
                        getNewReport(levels, i + 1).areLevelsIncreasing();
            }
        }
        return true;
    }

    private Report getNewReport(List<Long> levels, int index) {
        var newLevel = new ArrayList<>(levels);
        newLevel.remove(index);
        return new Report(newLevel);
    }

    public boolean isValidByToleratingOneBadLevel() {
        return areLevelsDecreasingByRemovingOneElement() || areLevelsIncreasingByRemovingOneElement();
    }
}
