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
        int idDelete = Integer.valueOf(input.askStr(" Enter number of id for delete "));
        if (tracker.delete(idDelete)) {
            out.println("successful");
        } else {
            out.println("failed");
        }
        return true;
    }
}
