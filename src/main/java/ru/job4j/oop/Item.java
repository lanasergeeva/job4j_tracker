package ru.job4j.oop;

import java.time.LocalDateTime;

    public class Item {

        private String name;
        private int id;
        private LocalDateTime created = LocalDateTime.now();

        public Item() {
        }

        public Item(String name) {
            this.name = name;
        }

        public Item(String name, int id) {
            this.name = name;
            this.id = id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public LocalDateTime getCreated() {
            return created;
        }
    }

