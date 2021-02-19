package ru.job4j.exer.compor;
import java.util.Comparator;

public class NullFirstMethod {
    public static Comparator<String> nullFirst() {
        return Comparator.reverseOrder();
    }
}

