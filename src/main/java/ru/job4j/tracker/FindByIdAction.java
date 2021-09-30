package ru.job4j.tracker;

import java.util.Objects;

public class FindByIdAction implements UserAction {

    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Find item by Id ===");
        int id = input.askInt(" Enter number of id for searching ");
        Item itemFind = tracker.findById(id);
        out.println(Objects.requireNonNullElse(itemFind, "Заявка с таким id не найдена"));
        return true;
    }
}
