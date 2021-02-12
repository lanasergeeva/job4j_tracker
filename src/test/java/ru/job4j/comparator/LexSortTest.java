package ru.job4j.comparator;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import org.junit.Test;
import java.util.Arrays;

public class LexSortTest {
    @Test
    public void sortNum1and2and10() {
        String[] input = {
                "10. Task.",
                "1. Task.",
                "2. Task."
        };
        String[] out = {
                "1. Task.",
                "2. Task.",
                "10. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }

    @Test
    public void sortNum14and25and103() {
        String[] input = {
                "103. Task.",
                "14. Task.",
                "25. Task."
        };
        String[] out = {
                "14. Task.",
                "25. Task.",
                "103. Task."
        };
        Arrays.sort(input, new LexSort());
        assertThat(input, is(out));
    }
}