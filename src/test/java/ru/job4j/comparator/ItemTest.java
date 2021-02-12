package ru.job4j.comparator;

import org.junit.Test;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ItemTest {
    @Test
    public void sortItem() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1"));
        items.add(new Item("5"));
        items.add(new Item("6"));
        items.add(new Item("2"));
        items.add(new Item("3"));
        Collections.sort(items, new ItemComparator());
        assertThat(items.get(0).getName(), is("1"));
        assertThat(items.get(1).getName(), is("2"));
        assertThat(items.get(2).getName(), is("3"));
        assertThat(items.get(3).getName(), is("5"));
        assertThat(items.get(4).getName(), is("6"));
    }

    @Test
    public void sortItemReverse() {
        List<Item> items = new ArrayList<Item>();
        items.add(new Item("1"));
        items.add(new Item("5"));
        items.add(new Item("6"));
        items.add(new Item("2"));
        items.add(new Item("3"));
        Collections.sort(items, new ItemComparatorReverse());
        assertThat(items.get(0).getName(), is("6"));
        assertThat(items.get(1).getName(), is("5"));
        assertThat(items.get(2).getName(), is("3"));
        assertThat(items.get(3).getName(), is("2"));
        assertThat(items.get(4).getName(), is("1"));
    }
}