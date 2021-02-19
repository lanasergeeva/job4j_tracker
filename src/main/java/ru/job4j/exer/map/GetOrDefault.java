package ru.job4j.exer.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetOrDefault {
    private Map<Integer, List<String>> store = new HashMap<>();

    public void addValue(int index, List<String> list) {
        if (!store.containsKey(index)) {
            store.putIfAbsent(index, list);
        }
    }

    public List<String> getValue(int index) {
        List<String> list2 = new ArrayList<String>();
        if (store.containsKey(index)) {
            list2 = store.get(index);
        }
        return list2;
    }
}
