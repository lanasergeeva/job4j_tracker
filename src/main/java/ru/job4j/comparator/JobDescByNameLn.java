package ru.job4j.comparator;

import java.util.Comparator;

public class JobDescByNameLn implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
