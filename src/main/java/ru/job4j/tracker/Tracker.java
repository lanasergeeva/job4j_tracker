package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public  class Tracker {

    //private static Tracker traker = null;

    private List<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    /*private Tracker() {
    }*/

    /*public static Tracker getTraker() {
        if (traker == null) {
            traker = new Tracker();
        }
        return traker;
    }*/

    public Item add(Item item) {
        item.setId(ids++);
        items.add(size++, item);
        return item;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> itemName = new ArrayList<>();
        for (Item names : items) {
            if (names.getName().equals(key)) {
                itemName.add(names);
            }
        }
        return itemName;
    }

    public List<Item> findAll() {
        return items;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            item.setId(id);
            items.set(index, item);
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            items.remove(index);
            size--;
        }
        return rsl;
    }
}
