package ru.job4j.exer.compor;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class SortBySet {
    public static Set<String> sort(List<String> list) {
        Set<String> set = new HashSet<>();
        set.addAll(list);
        Set<String> sorted = new TreeSet(set);
        return set;
    }
}
