package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int idEdit = Integer.valueOf(input.askStr(" Enter id: "));
        String nameEnter = input.askStr(" Enter name: ");
        Item itemEdit = new Item(nameEnter);
        itemEdit.setName(nameEnter);
        if (tracker.replace(idEdit, itemEdit)) {
            System.out.println("successful");
        } else {
            System.out.println("failed");
        }
        return true;
    }
}
