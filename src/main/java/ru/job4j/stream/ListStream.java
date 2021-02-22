package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ListStream {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(-5);
        list.add(2);
        list.add(8);
        list.add(-3);
        list.add(1);
        List<Integer> result = list.stream().filter(element
                -> element > 0).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}