package ru.job4j.tracker;

public class StartUI {

    public static void main(String[] args) {
        Tracker track = new Tracker();
        Item item = new Item();
        System.out.println(track.add(item));
        System.out.println(track.findById(4));
    }
}
