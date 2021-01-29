package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void driveStr() {
        System.out.println("Passengers are carried by bus");
    }

    @Override
    public void passengersInt(int passengers) {
        System.out.println("Number of passengers is " + passengers);
    }

    @Override
    public double petrolInt(double petrol) {
        return petrol * 52;
    }
}
