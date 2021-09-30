package ru.job4j.tracker;

public class ReplaceAction implements UserAction {

    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Edit item ====";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        int id = input.askInt("Enter id: ");
        String nameEnter = input.askStr(" Enter name: ");
        Item itemEdit = new Item(nameEnter);
        itemEdit.setName(nameEnter);
        if (tracker.replace(id, itemEdit)) {
           out.println("successful");
        } else {
            out.println("failed");
        }
        return true;
    }
}
