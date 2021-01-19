package ru.job4j.oop;

import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;
import org.junit.Test;
import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    @Test
    public void when13to56then5() {
        double expected = 2;
        Point a = new Point(0, 0);
        Point b = new Point(0, 2);
        double out = a.distance(b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when3dFirst() {
        double expected = 5;
        Point a = new Point(0, -3, 3);
        Point b = new Point(3, 1, 3);
        double out = a.distance3d(a, b);
        Assert.assertEquals(expected, out, 0.01);
    }

    @Test
    public void when3DSecond() {
        double expected = 8.66;
        Point a = new Point(-1, 3, 3);
        Point b = new Point(6, 2, -2);
        double out = a.distance3d(a, b);
        Assert.assertEquals(expected, out, 0.01);
    }
}
