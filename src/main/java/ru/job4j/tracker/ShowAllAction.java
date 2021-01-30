package ru.job4j.tracker;

public class ShowAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] itemsAll = tracker.findAll();
        for (Item item : itemsAll) {
            System.out.println(item);
        }
        return true;
    }
}
