package ru.job4j.exer.map;

import java.util.*;

public class NonUniqueString {
    public static Map<String, Boolean> checkData(String[] strings) {
        Map<String, Boolean> rsl = new HashMap<>();
        List<String> check = new ArrayList<>();
        boolean val = true;
        check = Arrays.asList(strings);
        for (String s : check) {
            if (check.indexOf(s) != check.lastIndexOf(s) && !rsl.containsKey(s)) {
                rsl.put(s, val);
            } else if (!rsl.containsKey(s)) {
                val = false;
                rsl.put(s, val);
            }
        }
        return rsl;
    }
}

