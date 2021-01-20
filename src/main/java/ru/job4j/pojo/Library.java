package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book bookOne = new Book("Братья Карамазовы", 830);
        Book bookTwo = new Book("Преступление и наказание", 550);
        Book bookThree = new Book("Идиот", 590);
        Book bookFour = new Book("Clean code", 10);
        Book[] books = new Book[4];
        books[0] = bookOne;
        books[1] = bookTwo;
        books[2] = bookThree;
        books[3] = bookFour;
        for (int index = 0; index < books.length; index++) {
            Book bk = books[index];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Change 0 and 3 indices");
            Book temp = books[0];
            books[0] = books[3];
            books[3] = temp;
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            System.out.println(bk.getName() + " - " + bk.getPages());
        }
        System.out.println("Book name is - ");
        for (int i = 0; i < books.length; i++) {
            Book bk = books[i];
            if (bk.getName().equals("Clean code")) {
                System.out.println(bk.getName() + " - " + bk.getPages());
            }
        }
    }
}
