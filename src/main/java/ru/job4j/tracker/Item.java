package ru.job4j.tracker;
import java.time.*;
import java.time.format.*;

public class Item {
    private String name;
    private int id;
    private LocalDateTime created = LocalDateTime.now();

    public Item() {
    }

    public Item(String name) {
        this.name = name;
     }

     public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item itemOne = new Item("Roman");
        Item itemTwo = new Item("Ivan", 336887);
    }
}