package com.junitreview.junitdemo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DemoUtilsTest {
    @Test
    void testEqualsAndNotEquals() {
        // set up
        DemoUtils demoUtils = new DemoUtils();

        // assert
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(8, demoUtils.add(2,4), "2+4 must not be 8");
    }

    @Test
    void testNullAndNotNull() {
        DemoUtils demoUtils = new DemoUtils();

        String str1 = null;
        String str2 = "junit review";

        assertNull(demoUtils.checkNull(str1), "Object should be null");
        assertNotNull(demoUtils.checkNull(str2), "Object should not be null");
    }
}
