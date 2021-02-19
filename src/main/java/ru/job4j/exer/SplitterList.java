package ru.job4j.exer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.UnaryOperator;

public class SplitterList {
    public static List<String> split(List<String> left, List<String> middle, List<String> right) {
        left.retainAll(middle);
        left.removeAll(right);
        return left;
    }
}
