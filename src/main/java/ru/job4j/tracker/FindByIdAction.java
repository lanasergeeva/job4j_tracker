package ru.job4j.tracker;

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
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ===");
        int idFind = Integer.valueOf(input.askStr(" Enter number of id for searching "));
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            out.println(itemFind);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
