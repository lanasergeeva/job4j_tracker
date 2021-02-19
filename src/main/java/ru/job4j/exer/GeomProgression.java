package ru.job4j.exer;

import java.util.ArrayList;
import java.util.List;

public class GeomProgression {
    public static int generateAndSum(int first, int denominator, int count) {
        List<Integer> list = new ArrayList<>();
        list.add(first);
        int rsl = 0;
        for (int i = 1; i < count; i++) {
            int temp = (int) Math.pow(denominator, i);
            int value = first * temp;
            list.add(i, value);
        }
        for (Integer integer : list) {
            rsl = rsl + integer;
        }
        return rsl;
    }
}
