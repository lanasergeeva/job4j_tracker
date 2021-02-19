package ru.job4j.exer.set;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PangramTest  {
    @Test
    public void checkString() {
        String str = "Jackdaws love my big sphinx of quartz";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(true));
    }

    @Test
    public void checkString2() {
        String str = "Jackdaws lovev mym bigG sphinx of quartz";
        boolean b = Pangram.checkString(str);
        assertThat(b, is(false));
    }
}
