package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Article {
    public static boolean generateBy(String origin, String line) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        String regex = "((?!^)\\b)";
        first.addAll(Arrays.asList(origin.split(regex)));
        second.addAll(Arrays.asList(line.split(regex)));
        return first.containsAll(second) ? true : false;
    }
}

