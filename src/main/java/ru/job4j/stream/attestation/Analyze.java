package ru.job4j.stream.attestation;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                .stream()
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D))).collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        s -> s.getName(),
                        LinkedHashMap::new,
                        Collectors.averagingDouble(s -> s.getScore())

                ))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream.map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                .stream()
                .mapToInt(s -> s.getScore())
                .sum()))
                .max(Comparator.comparing(t -> t.getScore()))
                .orElse(null);
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream.flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(
                        s -> s.getName(),
                        HashMap::new,
                        Collectors.summingDouble(s -> s.getScore())

                ))
                .entrySet()
                .stream()
                .map(t -> new Tuple(t.getKey(), t.getValue()))
                .max(Comparator.comparing(tuple -> tuple.getScore()))
                .orElse(null);
    }
}
