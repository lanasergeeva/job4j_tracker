package ru.job4j.collection;

import java.util.*;

public class FreezeStr {
    public static boolean eq(String left, String right) {
        Map<Character, Integer> check = new HashMap<>();
        for (int i = 0; i < left.length(); i++) {
            char key = left.charAt(i);
            if (check.containsKey(key)) {
                check.put(key, check.get(key) + 1);
            }
                check.putIfAbsent(key, 0);
            }
        for (int i = 0; i < right.length(); i++) {
            char key = right.charAt(i);
            if (check.containsKey(key) && check.get(key) != 0) {
                check.put(key, check.get(key) - 1);
            } else {
                check.remove(key);
            }
        }
        return check.isEmpty();
    }
}



/* public static boolean eq(String left, String right) {
         List<String> arrayOne = new ArrayList<>();
         List<String> arrayTwo = new ArrayList<>();
         arrayOne.addAll(Arrays.asList(left.split("")));
         arrayTwo.addAll(Arrays.asList(right.split("")));
         Collections.sort(arrayOne);
         Collections.sort(arrayTwo);
         return arrayOne.equals(arrayTwo);
     }*/
        /*List<String> one = Arrays.asList(left.split(""));
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
        return arr.isEmpty();
    }
}*/
