package ru.job4j.tracker;

public class Item {
    private String name;
    private int id;

    public Item() {
    }

     public Item(String name) {
        this.name = name;
     }

     public Item(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        Item item = new Item();
        Item itemOne = new Item("Roman");
        Item itemTwo = new Item("Ivan", 336887);
    }
}