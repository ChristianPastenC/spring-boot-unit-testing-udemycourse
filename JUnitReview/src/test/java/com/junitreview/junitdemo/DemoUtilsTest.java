package com.junitreview.junitdemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DemoUtilsTest {
    @Test
    void testEqualsAndNotEquals() {
        // set up
        DemoUtils demoUtils = new DemoUtils();

        int expected = 6;

        // execute
        int actual = demoUtils.add(2, 4);

        // assert
        Assertions.assertEquals(expected, actual, "2+4 must be 6");
    }
}
