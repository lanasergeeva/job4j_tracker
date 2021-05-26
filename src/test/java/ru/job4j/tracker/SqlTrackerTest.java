package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class SqlTrackerTest {
    public Connection init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            return DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password"));
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Test
    public void createItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            tracker.add(new Item("name"));
            assertThat(tracker.findByName("name").size(), is(1));
        }
    }

    @Test
    public void replaceItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            Item item2 = new Item("Leo");
            Item rsl = new Item("Mario");
            tracker.add(item1);
            tracker.add(item2);
            tracker.replace(item2.getId(), rsl);
            assertThat(tracker.findById(item2.getId()).getName(), is("Mario"));
        }
    }

    @Test
    public void deleteItem() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            Item item2 = new Item("Leo");
            tracker.add(item1);
            tracker.add(item2);
            assertTrue(tracker.delete(item2.getId()));
        }
    }

    @Test
    public void findItemById() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            Item item2 = new Item("Leo");
            tracker.add(item1);
            tracker.add(item2);
            assertThat(tracker.findById(item2.getId()), is(item2));
        }
    }

    @Test
    public void findItemByName() throws Exception {
        try (SqlTracker tracker = new SqlTracker(ConnectionRollback.create(this.init()))) {
            Item item1 = new Item("name");
            Item item2 = new Item("Leo");
            Item item3 = new Item("Leo");
            List<Item> list = new ArrayList<>(List.of(item2, item3));
            tracker.add(item1);
            tracker.add(item2);
            tracker.add(item3);
            assertThat(tracker.findByName("Leo"), is(list));
        }
    }
}