package com.junitreview.junitdemo;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("Executes before all test methods");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Executes after all test methods");
    }

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
        System.out.println("Executes before each test case");
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Executes after each test case");
    }

    @Test
    void testEqualsAndNotEquals() {
        System.out.println("Test Equals and not equals");
        assertEquals(6, demoUtils.add(2,4), "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9), "1+9 must not be 6");
    }

    @Test
    void testNullAndNotNull() {
        System.out.println("Test Null and not null");
        String str1 = null;
        String str2 = "junit review";

        assertNull(demoUtils.checkNull(str1), "object should be null");
        assertNotNull(demoUtils.checkNull(str2), "object should not be null");
    }
}
