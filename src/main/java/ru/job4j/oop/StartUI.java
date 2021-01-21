package ru.job4j.oop;

import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item i = new Item();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(i.getCreated().format(formatter));
    }
}
