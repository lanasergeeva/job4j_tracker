package ru.job4j.profession;

public class Builder extends Enginner {

    private String smeta;

    Builder(String name, String surname, String education, int birthday, int count, String smeta) {
        super(name, surname, education, birthday, count);
        this.smeta = smeta;
    }

    public String building() {
        return smeta;
    }
}
