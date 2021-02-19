package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        List<String> arrayOne = new ArrayList<>();
        List<String> arrayTwo = new ArrayList<>();
        arrayOne.addAll(Arrays.asList(left.split("")));
        arrayTwo.addAll(Arrays.asList(right.split("")));
        Collections.sort(arrayOne);
        Collections.sort(arrayTwo);
        return arrayOne.equals(arrayTwo);
    }
}

