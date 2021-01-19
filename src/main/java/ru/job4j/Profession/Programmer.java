package ru.job4j.Profession;

public class Programmer extends Enginner {
    private String computer;

    Programmer(String name, String surname, String education, int birthday, int count, String computer) {
        super(name, surname, education, birthday, count);
        this.computer = computer;
    }

    public String programming() {
        return computer;
    }

}
