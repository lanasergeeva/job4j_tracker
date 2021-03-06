package ru.job4j.stream;

public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Profile(String city, String street, int home, int apartment) {
        address = new Address(city, street, home, apartment);
    }

    public Address getAddress() {
        return address;
    }

}

