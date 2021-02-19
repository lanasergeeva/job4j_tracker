package ru.job4j.exer;

import java.util.List;

public class UniqueElement {
    public static boolean checkList(List<String> list, String str) {
        boolean rsl = false;
        if (list.contains(str)) {
            int indexOne = list.indexOf(str);
            int indexTwo = list.lastIndexOf(str);
            rsl = (indexOne == indexTwo) ? true : false;
        }
        return rsl;
    }
}
