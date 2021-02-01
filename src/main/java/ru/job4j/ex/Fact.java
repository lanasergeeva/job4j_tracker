package ru.job4j.ex;

public class Fact {
    public static void main(String[] args) {
        Fact f = new Fact();
        System.out.println(f.calc(5));
        System.out.println(f.calc(-4));
    }

    public int calc(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Number should be positiv");
        }
        int rsl = 1;
        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return rsl;
    }
}
