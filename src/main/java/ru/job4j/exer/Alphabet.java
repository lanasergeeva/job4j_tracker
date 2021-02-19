package ru.job4j.exer;

import java.util.*;

public class Alphabet  {
    public static String reformat(String s) {
        List<String> list = new ArrayList<>();
        String[] liter = s.split("");
        list = Arrays.asList(liter);
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String st : list) {
            sb.append(st);
        }
        String s2 = new String(sb);
        return s2;
    }
}
