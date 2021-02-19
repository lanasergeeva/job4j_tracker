package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    /* public static boolean eq(String left, String right) {
         List<String> arrayOne = new ArrayList<>();
         List<String> arrayTwo = new ArrayList<>();
         arrayOne.addAll(Arrays.asList(left.split("")));
         arrayTwo.addAll(Arrays.asList(right.split("")));
         Collections.sort(arrayOne);
         Collections.sort(arrayTwo);
         return arrayOne.equals(arrayTwo);
     }*/
    public static boolean eq(String left, String right) {
        Map<String, Integer> arr = new HashMap<>();
        List<String> one = Arrays.asList(left.split(""));
        List<String> two = Arrays.asList(right.split(""));
        int val = 0;
        for (String s : one) {
            if (arr.containsKey(s)) {
                arr.put(s, arr.get(s) + 1);
            }
            arr.putIfAbsent(s, val);
        }
        for (String s : two) {
            if (arr.containsKey(s) && arr.get(s) != 0) {
                arr.put(s, arr.get(s) - 1);
            } else {
                arr.remove(s);
            }
        }
        return arr.isEmpty() ? true : false;
    }
}
