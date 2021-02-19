package ru.job4j.exer.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class Firewall {
    public static String checkName(String s, Set<String> words) {
        String rsl = "Вы сделали правильный выбор!";
        List<String> array = new ArrayList<>();
        String[] first = s.split(" ");
        array = Arrays.asList(first);
        for (String st : array) {
            if (words.contains(st)) {
                rsl = "Выберите другую статью...";
                break;
            }
        }
        return rsl;
    }
}
