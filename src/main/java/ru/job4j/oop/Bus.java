package ru.job4j.oop;

public class Bus implements Vehicle {

    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " двигается по автомобильным дорогам");
    }

    @Override
    public double ticket(double price) {
        return price;
    }
}
