package ru.job4j.exer.map;

import java.util.*;

public class Dictionary {
    public static Map<String, List<String>> collectData(String[] strings) {
        Map<String, List<String>> rsl = new HashMap<>();
        Set<String> test = new HashSet<>();

        for (String s : strings) {
            test.add(String.valueOf(s.charAt(0)));
        }

        for (String key : test) {
            List<String> array = new ArrayList<>();
            array.clear();
            for (String s : strings) {
                if (s.startsWith(key)) {
                    array.add(s);
                }
            }
            rsl.put(key, array);
        }
        return rsl;
    }
}



        /*for (int i = 0; i < strings.length-1; i++) {
            //List<String> array = new ArrayList<>();
            String key = strings[i];
            char temp = key.charAt(0);
            String val = String.valueOf(temp);
            if (array.size() > 0) {
                check = array.get(array.size() - 1);
            }
            if (check != null && !key.startsWith(String.valueOf(check.charAt(0)))) {
                array.clear();
            }
            if (strings[i].startsWith(val)) {
                //List<String> array = new ArrayList<>();
                array.add(strings[i]);
            }
            if (!strings[i + 1].startsWith(val)) {
                rsl.put(val, array);
            }*/

