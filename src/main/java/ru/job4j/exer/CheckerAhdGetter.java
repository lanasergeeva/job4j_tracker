package ru.job4j.exer;

import java.util.List;

public class CheckerAhdGetter {
    public static String getElement(List<String> list) {
        String rsl = "";
        boolean listEmpty = list.isEmpty();
        if (!listEmpty) {
            rsl = list.get(0);
            }
        return rsl;
    }
}
