package ru.job4j.exer;

import java.util.List;

public class RepositionElement {
    public static List<String> changePosition(List<String> list, int index) {
        String last = list.remove(list.size() - 1);
        if (index < list.size()) {
            list.set(index, last);
        }
        return list;
    }
}

