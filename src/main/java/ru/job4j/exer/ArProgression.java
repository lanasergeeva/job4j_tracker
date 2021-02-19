package ru.job4j.exer;

import java.util.List;

public class ArProgression {
    public static int checkData(List<Integer> data) {
        boolean da = false;
        int rsl = 0;
        for (int i = 1; i < data.size() - 1; i++) {
            da = (data.get(i) == ((data.get(i - 1) + data.get(i + 1)) / 2)) ? true : false;
            if (!da) {
                break;
            }
        }
        if (da) {
            for (Integer i : data) {
                rsl = rsl + i;
            }
        }
        return rsl;
    }
}
