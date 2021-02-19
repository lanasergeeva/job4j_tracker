package ru.job4j.exer.set;

import java.util.*;

public class Jackpot {
    public static boolean checkYourWin(String[] combination) {
        List<String> array = new ArrayList<>();
        Set<String> list = new HashSet<>();
        array = Arrays.asList(combination);
        list.addAll(array);
        return (list.size() == 1) ? true : false;
    }
}

