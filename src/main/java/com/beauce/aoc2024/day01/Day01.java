package com.beauce.aoc2024.day01;

import java.util.ArrayList;
import java.util.List;

public class Day01 {

    public BothList getBothList(List<String> input) {
        var firstList = new ArrayList<Integer>();
        var secondList = new ArrayList<Integer>();
        for (String line : input) {
            String[] array = line.split(" ");
            int first = Integer.parseInt(array[0].trim());
            int last = Integer.parseInt(array[array.length - 1].trim());
            firstList.add(first);
            secondList.add(last);
        }
        return new BothList(firstList.stream().toList(), secondList.stream().toList());
    }

    public int getTotal(List<Integer> diffList) {
        return diffList.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public long getMultiplyTotal(List<Long> multipliedNumberList) {
        return multipliedNumberList.stream()
                .mapToLong(Long::longValue)
                .sum();
    }
}
