package ru.job4j.Profession;

public class Doctor extends Profession {

    private String healing;
    private String pacient;

    Doctor(String name, String surname, String education, int birthday, String healing, String pacient) {
        super(name, surname, education, birthday);
        this.healing = healing;
        this.pacient = pacient;
    }

    public String diagnosis(String pacient) {
        return pacient;
    }
}
