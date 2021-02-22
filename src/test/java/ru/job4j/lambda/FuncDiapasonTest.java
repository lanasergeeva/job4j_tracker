package ru.job4j.lambda;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class FuncDiapasonTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionX() {
        List<Double> result = FuncDiapason.diapason(5, 8, x -> x);
        List<Double> expected = Arrays.asList(5D, 6D, 7D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionXandX() {
        List<Double> result = FuncDiapason.diapason(1, 5, x -> x * x);
        List<Double> expected = Arrays.asList(1D, 4D, 9D, 16D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLinearFunctionXtoX() {
        List<Double> result = FuncDiapason.diapason(3, 6, x -> Math.pow(x, x));
        List<Double> expected = Arrays.asList(27D, 256D, 3125D);
        assertThat(result, is(expected));
    }

}