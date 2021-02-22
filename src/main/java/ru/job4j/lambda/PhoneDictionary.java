package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> pred1 = person -> person.getPhone().contains(key);
        Predicate<Person> pred2 = person -> person.getAddress().contains(key);
        Predicate<Person> pred3 = person -> person.getName().contains(key);
        Predicate<Person> pred4 = person -> person.getSurname().contains(key);
        Predicate<Person> combine = pred1.or(pred2).or(pred3).or(pred4);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
