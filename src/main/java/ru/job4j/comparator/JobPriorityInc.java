package ru.job4j.comparator;

import java.util.Comparator;

public class JobPriorityInc implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(first.getPriority(), second.getPriority());
    }
}
