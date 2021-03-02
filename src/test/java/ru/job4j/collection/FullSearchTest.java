package ru.job4j.collection;

import org.junit.Test;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FullSearchTest  {
    @Test
    public void extractNumber() {
        List<TaskSet> tasks = List.of(
                new TaskSet("1", "First desc"),
                new TaskSet("2", "Second desc"),
                new TaskSet("1", "First desc")
        );
        Set<String> expected = new HashSet<>(Set.of("1", "2"));
        assertThat(FullSearch.extractNumber(tasks), is(expected));
    }
}