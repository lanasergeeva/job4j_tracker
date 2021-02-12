package ru.job4j.comparator;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;

public class JobSorter {
    public static void main(String[] args) {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobNameInc().thenComparing(new JobDescByPriority()));
        System.out.println(jobs);
        Comparator<Job> comb = new JobDescByNameLn()
                .thenComparing(new JobNameInc())
                .thenComparing(new JobDescByPriority());
        Collections.sort(jobs, comb);
    }
}
