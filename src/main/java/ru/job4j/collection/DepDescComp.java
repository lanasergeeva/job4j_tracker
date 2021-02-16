package ru.job4j.collection;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        String left = first.split("/")[0];
        String right = second.split("/")[0];
        int temp = right.compareTo(left);
        return (temp == 0) ? first.compareTo(second) : temp;
    }
}
