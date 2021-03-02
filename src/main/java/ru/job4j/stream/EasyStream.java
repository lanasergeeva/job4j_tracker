package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {
    private List<Integer> list = new ArrayList<>();

    private EasyStream() {
    }

    private EasyStream(List<Integer> list) {
        this.list = list;
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> test = new ArrayList<>();
        for (Integer integer : list) {
            test.add(fun.apply(integer));
        }
        return new EasyStream(test);
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> test = new ArrayList<>();
        for (Integer integer : list) {
            if (fun.test(integer)) {
                test.add(integer);
            }
        }
        return new EasyStream(test);
    }

    public List<Integer> collect() {
        return new ArrayList<>(list);
    }
}
     /*public static List<Integer> pi(List<Integer> source, Function<Integer, Integer> fun,
                                 Predicate<Integer> pred) {
        return   source
                .stream()
                .map(fun)
                .filter(pred)
                .collect(Collectors.toList());*/

