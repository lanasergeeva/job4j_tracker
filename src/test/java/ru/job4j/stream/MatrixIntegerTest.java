package ru.job4j.stream;


import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MatrixIntegerTest {
    @Test
    public void whenConverMatrix() {
        Integer[][] check = {
                {9, 8, 7},
                {6, 5, 4},
        };

        List<Integer> rsl = MatrixInteger.converMatrix(check);
        List<Integer> expected = Arrays.asList(9, 8, 7, 6, 5, 4);
        assertThat(rsl, is(expected));
    }
}