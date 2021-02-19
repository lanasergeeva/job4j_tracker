package ru.job4j.exer.set;

import java.util.*;

public class Isogram {
    public static boolean checkString(String s) {
        String[] first = s.split("");
        List<String> array = new ArrayList<>();
        Set<String> list = new HashSet<>();
        array = Arrays.asList(first);
        list.addAll(array);
        return (list.size() == array.size()) ? true : false;
    }
}

