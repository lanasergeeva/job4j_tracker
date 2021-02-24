package ru.job4j.stream;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StudentMapTest  {
    private List<Student> students = new ArrayList<>();

    @Before
    public void setUp() {
        students.add(new Student(10, "Surname1"));
        students.add(new Student(20, "Surname2"));
        students.add(new Student(30, "Surname3"));
        students.add(new Student(30, "Surname3"));
    }

    @Test
    public void whenStudentAddToMapWithTwoSameStudents() {
        Map<String, Student> rsl = StudentMap.listmap(students);
        Map<String, Student> expected = new HashMap<>();
        expected.put(students.get(0).getSurname(), students.get(0));
        expected.put(students.get(1).getSurname(), students.get(1));
        expected.put(students.get(2).getSurname(), students.get(2));
        assertThat(rsl, is(expected));
    }
}