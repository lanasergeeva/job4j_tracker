package ru.job4j.Profession;

public class Enginner extends Profession {

    private int count;

    Enginner(String name, String surname, String education, int birthday, int count) {
        super(name, surname, education, birthday);
        this.count = count;
    }

    private void calculate() {

    }

}
