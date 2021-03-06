package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentMap {
    public static Map<String, Student> listmap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        Student::getSurname, st -> st, (st1, st2) -> st1));
    }
}
