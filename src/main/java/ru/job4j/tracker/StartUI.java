package ru.job4j.tracker;

public class StartUI {

    private String[] menu = {"0. Add new Item", "1. Show all items", "2. Edit item",
            "3. Delete item", "4. Find item by Id", "5. Find items by name",
            "6. Exit Program"};

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(input.askStr("Select: "));
            if (select == 0) {
                System.out.println(menu[select]);
                String name = input.askStr(" Enter name: ");
                Item item = new Item(name);
                tracker.add(item);
                System.out.println(menu[select] + " " + " name is " + tracker.add(item).getName());
            } else if (select == 1) {
                System.out.println("=== Show all items ====");
                Item[] itemsAll = tracker.findAll();
                for (Item item : itemsAll) {
                    System.out.println(item);
                }
            } else if (select == 2) {
                System.out.println(menu[select]);
                int idEdit = Integer.valueOf(input.askStr(" Enter id: "));
                String nameEnter = input.askStr(" Enter name: ");
                Item itemEdit = new Item(nameEnter);
                itemEdit.setName(nameEnter);
                if (tracker.replace(idEdit, itemEdit)) {
                    System.out.println("successful");
                } else {
                    System.out.println("failed");
                }
            } else if (select == 3) {
                System.out.println(menu[select]);
                int idDelete = Integer.valueOf(input.askStr(" Enter number of id for delete "));
                if (tracker.delete(idDelete)) {
                    System.out.println("successful");
                } else {
                    System.out.println("failed");
                }
            } else if (select == 4) {
                System.out.println(menu[select]);
                int idFind = Integer.valueOf(input.askStr(" Enter number of id for searching "));
                Item itemFind = tracker.findById(idFind);
                if (itemFind != null) {
                    System.out.println(itemFind);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println(menu[select]);
                String nameFind = input.askStr(" Enter name of id for searching ");
                Item[] findName = tracker.findByName(nameFind);
                if (findName.length > 0) {
                    for (Item itemFindName : findName) {
                        System.out.println(itemFindName);
                    }
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        for (String m : menu) {
            System.out.println(m);
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
