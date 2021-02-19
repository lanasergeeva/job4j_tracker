package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Article {
    /*public static boolean generateBy(String origin, String line) {
        List<String> first = new ArrayList<>();
        List<String> second = new ArrayList<>();
        String regex = "((?!^)\\b)";
        first.addAll(Arrays.asList(origin.split(regex)));
        second.addAll(Arrays.asList(line.split(regex)));
        return first.containsAll(second) ? true : false;
    }*/
    public static boolean generateBy(String origin, String line) {
        String regex = "((?!^)\\b)";
        List<String> second = Arrays.asList(line.split(regex));
        HashSet<String> hs = new HashSet<>(Arrays.asList(origin.split(regex)));
        for (String s : second) {
            if (!hs.contains(s)) {
                return false;
            }
        }
        return true;
    }
}

