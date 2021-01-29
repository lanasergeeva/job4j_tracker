package ru.job4j.tracker;
import java.util.Scanner;

public class StartUI {

    private String[] menu = {"0. Add new Item", "1. Show all items", "2. Edit item",
            "3. Delete item", "4. Find item by Id", "5. Find items by name",
            "6. Exit Program"};

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.print("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println(menu[select]);
                System.out.print(" Enter name: ");
                String name = scanner.nextLine();
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
                System.out.println(" Enter id: ");
                int idEdit = Integer.valueOf(scanner.nextLine());
                System.out.println(" Enter name: ");
                String nameEnter = scanner.nextLine();
                Item itemEdit = new Item(nameEnter);
                itemEdit.setName(nameEnter);
                if (tracker.replace(idEdit, itemEdit)) {
                    System.out.println("successful");
                } else {
                    System.out.println("failed");
                }
            } else if (select == 3) {
                System.out.println(menu[select]);
                System.out.println("Enter number of id for delete");
                int idDelete = Integer.valueOf(scanner.nextLine());
                if (tracker.delete(idDelete)) {
                    System.out.println("successful");
                } else {
                    System.out.println("failed");
                }
            } else if (select == 4) {
                System.out.println(menu[select]);
                System.out.println("Enter number of id for searching");
                int idFind = Integer.valueOf(scanner.nextLine());
                Item itemFind = tracker.findById(idFind);
                if (itemFind != null) {
                    System.out.println(itemFind);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }
            } else if (select == 5) {
                System.out.println(menu[select]);
                System.out.println("Enter name of id for searching");
                String nameFind = scanner.nextLine();
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
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
