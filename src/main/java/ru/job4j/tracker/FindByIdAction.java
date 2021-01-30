package ru.job4j.tracker;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idFind = Integer.valueOf(input.askStr(" Enter number of id for searching "));
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            System.out.println(itemFind);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
