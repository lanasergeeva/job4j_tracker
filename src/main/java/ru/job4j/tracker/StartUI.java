package ru.job4j.tracker;
import java.time.*;
import java.time.format.*;

public class StartUI {

    public static void main(String[] args) {
        Item i = new Item(LocalDateTime.now());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        System.out.println(i.getCreated().format(formatter));
    }
}
