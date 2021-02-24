package ru.job4j.stream;

import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfileCollectTest {

    private List<Profile> check = new ArrayList<>();

    @Before
    public void setUp() {
        check.add(new Profile("Kiev", "Shevchenko", 10, 74));
        check.add(new Profile("Sevastopol", "Lenina", 5, 14));
        check.add(new Profile("Magadan", "Pushkina", 15, 32));
        check.add(new Profile("Magadan", "Pushkina", 15, 32));
        check.add(new Profile("Sevastopol", "Shevchenko", 10, 74));
    }

    @Test
    public void whenJustAdressCollect() {
        List<Address> rsl = ProfileCollect.collect(check);
        List<Address> expected = Arrays.asList(
                new Address("Kiev", "Shevchenko", 10, 74),
                new Address("Sevastopol", "Lenina", 5, 14),
                new Address("Magadan", "Pushkina", 15, 32),
                new Address("Magadan", "Pushkina", 15, 32),
                new Address("Sevastopol", "Shevchenko", 10, 7)
        );
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenSameCity() {
        List<Address> rsl = ProfileCollect.collects(check);
        List<Address> expected = Arrays.asList(
                new Address("Kiev", "Shevchenko", 10, 74),
                new Address("Magadan", "Pushkina", 15, 32),
                new Address("Sevastopol", "Lenina", 5, 14),
                new Address("Sevastopol", "Shevchenko", 10, 7)
        );
        assertThat(rsl, is(expected));
    }
}