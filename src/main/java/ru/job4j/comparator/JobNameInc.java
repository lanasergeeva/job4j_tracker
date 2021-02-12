package ru.job4j.comparator;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class JobNameInc implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
