package ru.job4j.pojo;

import java.time.LocalDate;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName("Ivanov Nikita Ivanovich");
        student.setCourse(4);
        student.setDate(LocalDate.of(2012, 10, 15));
        System.out.println(student.getName());
        System.out.println(student.getCourse());
        System.out.println(student.getDate());
    }
}
