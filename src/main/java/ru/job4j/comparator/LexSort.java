package ru.job4j.comparator;

import java.util.Comparator;

public class LexSort implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        left = left.split(". ", 3)[0];
        right = right.split(". ", 3)[0];
        return Integer.compare(Integer.parseInt(left), Integer.parseInt(right));
    }
}

