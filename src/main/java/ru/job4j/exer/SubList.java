package ru.job4j.exer;

import java.util.ArrayList;
import java.util.List;

public class SubList {
    public static List<String> getElementsBetweenIndexes(List<String> list, String el) {
        List<String> rsl = new ArrayList<>();
        int one = list.indexOf(el);
        int two = list.lastIndexOf(el);
        if (list.contains(el) &&  one != two) {
            rsl = list.subList(one, two);
        }
        return rsl;
    }
}
