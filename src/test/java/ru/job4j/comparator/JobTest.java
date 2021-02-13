package ru.job4j.comparator;

import org.junit.Test;

import java.util.Comparator;
import static org.hamcrest.number.OrderingComparison.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenCompatorByNameAndPrority() {
        Comparator<Job> cmpNamePriority = new JobDescByNameLn().
                thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByNameInc() {
        Comparator<Job> cmpNameInc = new JobNameInc();
        int rsl = cmpNameInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByNameDesc() {
        Comparator<Job> cmpNameDesc = new JobDescByNameLn();
        int rsl = cmpNameDesc.compare(
                new Job("Impl task", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityInc() {
        Comparator<Job> cmpPriorityInc = new JobPriorityInc();
        int rsl = cmpPriorityInc.compare(
                new Job("Impl task", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenCompatorByPriorityDesc() {
        Comparator<Job> cmpPriorityDesc = new JobDescByPriority();
        int rsl = cmpPriorityDesc.compare(
                new Job("Impl task", 0),
                new Job("Fix bugs", 1)
        );
        assertThat(rsl, greaterThan(0));
    }

    @Test
    public void whenCompatorByPriorityIncandNameInk() {
        Comparator<Job> cmpIncNamePrio = new JobNameInc().thenComparing(new JobPriorityInc());
        int rsl = cmpIncNamePrio.compare(
                new Job("Impl task", 0),
                new Job("Impl task", 1)
        );
        assertThat(rsl, lessThan(0));
    }
}