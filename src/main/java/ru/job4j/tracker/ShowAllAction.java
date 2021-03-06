package ru.job4j.tracker;
import java.util.List;

public class ShowAllAction implements UserAction {

    private final Output out;

    public ShowAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Show all items ====");
        List<Item> findAll = tracker.findAll();
        for (Item item : findAll) {
            out.println(item);
        }
        return true;
    }
}
