package ru.job4j.profession;

    public  class Surgeon extends Doctor {

        private String scalpel;

        Surgeon(String name, String surname, String education,
                int birthday, String healing, String pacient, String scalpel) {
            super(name, surname, education, birthday, healing, pacient);
            this.scalpel = scalpel;
        }

        public String surgery() {
            return scalpel;
        }
    }
