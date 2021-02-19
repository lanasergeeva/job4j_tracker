package ru.job4j.exer.set;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.*;

public class Pangram {
    public static boolean checkString(String s) {
        List<String> array = new ArrayList<>();
        Set<String> list = new HashSet<>();
        List<String> array2 = new ArrayList<>();
        array2.add(" ");
        String temp = s.toLowerCase(Locale.ROOT).strip();
        String[] first = temp.split("");
        array = Arrays.asList(first);
        list.addAll(array);
        list.removeAll(array2);
        return (list.size() != array.size()) ? true : false;
    }
}
