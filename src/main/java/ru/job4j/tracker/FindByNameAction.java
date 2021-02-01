package ru.job4j.tracker;

public class FindByNameAction implements UserAction {

    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find item by Name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String nameFind = input.askStr(" Enter name of id for searching ");
        Item[] findName = tracker.findByName(nameFind);
        if (findName.length > 0) {
            for (Item itemFindName : findName) {
                out.println(itemFindName);
            }
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
