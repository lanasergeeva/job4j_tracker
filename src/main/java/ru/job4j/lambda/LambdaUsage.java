package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {
        String[] test = {"Fortune", "favors", "the", "bold", "true", "false"};
        Comparator<String> cmpDescSizeInfo = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return right.length() - left.length();
        };
        Arrays.sort(test, cmpDescSizeInfo);
        System.out.println(Arrays.toString(test));
    }
}
