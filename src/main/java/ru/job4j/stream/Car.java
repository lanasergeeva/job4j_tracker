package ru.job4j.stream;

public class Car {
    private String name;
    private String color;
    private int year;
    private double mileage;
    private int countOfDoors;
    private boolean insurancy;
    private int owners;

    static class BuilderCar {
        private String name;
        private String color;
        private int year;
        private double mileage;
        private int countOfDoors;
        private boolean insurancy;
        private int owners;

        Car build() {
            Car car = new Car();
            car.name = name;
            car.color = color;
            car.year = year;
            car.mileage = mileage;
            car.countOfDoors = countOfDoors;
            car.insurancy = insurancy;
            car.owners = owners;
            return car;
        }

        BuilderCar buildName(String name) {
            this.name = name;
            return this;
        }

        BuilderCar buildColor(String color) {
            this.color = color;
            return this;
        }

        BuilderCar buildYear(int year) {
            this.year = year;
            return this;
        }

        BuilderCar buildMileage(double mileage) {
            this.mileage = mileage;
            return this;
        }

        BuilderCar buildNCount(int countOfDoors) {
            this.countOfDoors = countOfDoors;
            return this;
        }

        BuilderCar buildInsurancy(boolean insurancy) {
            this.insurancy = insurancy;
            return this;
        }

        BuilderCar buildOwners(int owners) {
            this.owners = owners;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Car{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + ", year=" + year
                + ", mileage=" + mileage
                + ", countOfDoors=" + countOfDoors
                + ", insurancy=" + insurancy
                + ", owners=" + owners
                + '}';
    }

    public static void main(String[] args) {
        Car car = new BuilderCar()
                .buildName("Nissan Teana")
                .buildColor("Blue")
                .buildYear(2016)
                .buildMileage(53125.51)
                .buildNCount(4)
                .buildInsurancy(true)
                .buildOwners(1)
                .build();
        System.out.println(car);
    }
}
