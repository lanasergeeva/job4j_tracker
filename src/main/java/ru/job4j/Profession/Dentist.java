package ru.job4j.Profession;

public class Dentist extends Doctor {

    private  String forces;

    Dentist(String name, String surname, String education, int birthday, String healing, String pacient, String forces) {
        super(name, surname, education, birthday, healing, pacient);
        this.forces = forces;
    }

    public String helpTeeth() {
        return forces;
    }
}
