package ru.job4j.oop;

public class TransportAll {
    public static void main(String[] args) {
        Vehicle vehiclePlane = new Plane();
        Vehicle vehicleTrain = new Train();
        Vehicle vehicleBus = new Bus();

        Vehicle[] vehicles = new Vehicle[] {vehiclePlane, vehicleTrain, vehicleBus};
        for (Vehicle v : vehicles) {
            v.move();
        }
        }
    }
