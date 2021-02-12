package ru.job4j.comparator;

import java.util.Comparator;

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {
        int rsl = 0;
        int temp = (left.length() > right.length()) ? right.length() : left.length();
        for (int i = 0; i < temp; i++) {
            rsl = Integer.compare(left.charAt(i), right.charAt(i));
            if (rsl != 0) {
                break;
            }
        }
        if (rsl == 0 && left.length() != right.length()) {
            rsl = Integer.compare(left.length(), right.length());
        }
        return rsl;
    }
}
