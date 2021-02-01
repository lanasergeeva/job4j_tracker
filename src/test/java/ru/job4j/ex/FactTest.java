package ru.job4j.ex;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest  {

    @Test(expected = IllegalArgumentException.class)
    public void whenNumberNegativ() {
        Fact f = new Fact();
        f.calc(-4);
    }

    @Test
    public void whenNumberPositiv() {
        Fact f = new Fact();
        int rsl = f.calc(5);
        assertThat(rsl, is(120));
    }
}