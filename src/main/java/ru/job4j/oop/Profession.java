package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private int birthday;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

        public int getBirthday() {
        return birthday;
    }
}

   class Engineer extends Profession {

        public void count() {
        }
    }

    class Programmer extends Engineer {
    private String computer;

    public String programming() {
        return computer;
        }
    }

    class Builder extends Engineer {
    private String smeta;

     public String building() {
         return smeta;
     }
    }

    class Doctor extends Profession {
        private String healing;
        private String pacient;

        public String diagnosis(String pacient) {
        return pacient;
        }
    }

    class Surgeon extends Doctor {
    private String scalpel;

    public String surgery() {
        return scalpel;
        }
    }

    class Dentist extends Doctor {
    private  String forces;

    public String helpTeeth() {
        return forces;
        }
    }





