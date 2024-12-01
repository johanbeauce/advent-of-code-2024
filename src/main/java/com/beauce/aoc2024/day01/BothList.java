package com.beauce.aoc2024.day01;

import java.util.ArrayList;
import java.util.List;

public record BothList(
        List<Integer> leftList,
        List<Integer> rightList
) {
    public BothList sort() {
        return new BothList(
                leftList.stream().sorted(Integer::compareTo).toList(),
                rightList.stream().sorted(Integer::compareTo).toList());
    }

    public List<Integer> getDiffList() {
        var diffList = new ArrayList<Integer>();
        for (int i = 0; i < leftList.size(); i++) {
            diffList.add(getAbsoluteDifferenceBetweenTwoNumber(rightList.get(i), leftList.get(i)));
        }
        return diffList;
    }

    public List<Long> getListMultiplyNumberOfOccurrenceInTheSecondList() {
        return leftList.stream()
                .map(this::getNumberOfOccurrenceInRightList)
                .toList();
    }

    private Integer getAbsoluteDifferenceBetweenTwoNumber(Integer integer,
                                                          Integer integer1) {
        return Math.abs(integer - integer1);
    }

    private long getNumberOfOccurrenceInRightList(Integer integer) {
        return integer * rightList.stream()
                .filter(integer1 -> integer1.equals(integer))
                .count();
    }
}
