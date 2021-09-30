package ru.job4j.tracker;

public class DeleteAction implements UserAction {

    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt(" Enter number of id for delete ");
        if (tracker.delete(id)) {
            out.println("successful");
        } else {
            out.println("failed");
        }
        return true;
    }
}
