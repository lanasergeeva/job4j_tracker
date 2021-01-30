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
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.showAllItems(input, tracker);
            } else if (select == 2) {
                StartUI.replaceItem(input, tracker);
            } else if (select == 3) {
                StartUI.deleteItem(input, tracker);
            } else if (select == 4) {
                StartUI.findItemId(input, tracker);
            } else if (select == 5) {
                StartUI.findItemName(input, tracker);
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

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
    }

    public static void showAllItems(Input input, Tracker tracker) {
        System.out.println("=== Show all items ====");
        Item[] itemsAll = tracker.findAll();
        for (Item item : itemsAll) {
            System.out.println(item);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int idEdit = Integer.valueOf(input.askStr(" Enter id: "));
        String nameEnter = input.askStr(" Enter name: ");
        Item itemEdit = new Item(nameEnter);
        itemEdit.setName(nameEnter);
        if (tracker.replace(idEdit, itemEdit)) {
            System.out.println("successful");
        } else {
            System.out.println("failed");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int idDelete = Integer.valueOf(input.askStr(" Enter number of id for delete "));
        if (tracker.delete(idDelete)) {
            System.out.println("successful");
        } else {
            System.out.println("failed");
        }
    }

    public static void findItemId(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int idFind = Integer.valueOf(input.askStr(" Enter number of id for searching "));
        Item itemFind = tracker.findById(idFind);
        if (itemFind != null) {
            System.out.println(itemFind);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemName(Input input, Tracker tracker) {
        System.out.println("=== Find item by Name ===");
        String nameFind = input.askStr(" Enter name of id for searching ");
        Item[] findName = tracker.findByName(nameFind);
        if (findName.length > 0) {
            for (Item itemFindName : findName) {
                System.out.println(itemFindName);
            }
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        new StartUI().init(input, tracker);
    }
}
