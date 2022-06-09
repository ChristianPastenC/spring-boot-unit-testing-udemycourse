package com.junitreview.junitdemo;

import org.junit.jupiter.api.*;

import java.time.Duration;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

// @DisplayNameGeneration(DisplayNameGenerator.IndicativeSentences.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
class DemoUtilsTest {

    DemoUtils demoUtils;

    @BeforeEach
    void setupBeforeEach() {
        demoUtils = new DemoUtils();
    }

    @Test
    @DisplayName("Equals & not equals")
    void testEqualsAndNotEquals() {
        // System.out.println("Test Equals and not equals");
        assertEquals(6, demoUtils.add(2,4),
                "2+4 must be 6");
        assertNotEquals(6, demoUtils.add(1, 9),
                "1+9 must not be 6");
    }

    @Test
    @DisplayName("Multiply")
    void testMultiply() {
        assertEquals(12, demoUtils.multiply(4, 3));
    }

    @Test
    @DisplayName("Null & not null")
    void testNullAndNotNull() {
        // System.out.println("Test Null and not null");
        String str1 = null;
        String str2 = "junit review";

        assertNull(demoUtils.checkNull(str1),
                "object should be null");
        assertNotNull(demoUtils.checkNull(str2),
                "object should not be null");
    }

    @Test
    @DisplayName("Same and not same")
    void testSameAndNotSame() {
        String str = "junit review";
        assertSame(
                demoUtils.getAcademy(),
                demoUtils.getAcademyDuplicate(),
                "Objects should refer the same object"
        );
        assertNotSame(str, demoUtils.getAcademy(),
                "Objects should not refer the same object");
    }

    @Test
    @DisplayName("True and false")
    void testTrueFalse() {
        int gradeOne = 10;
        int gradeTwo = 5;

        assertTrue(demoUtils.isGreater(gradeOne, gradeTwo),
                "should be return true");
        assertFalse(demoUtils.isGreater(gradeTwo, gradeOne),
                "should be return false");
    }

    @Test
    @DisplayName("Array Equals")
    void testArrayEquals() {
        String[] stringArray = {"A", "B", "C"};
        assertArrayEquals(
                stringArray,
                demoUtils.getFirstThreeLettersOfAlphabet(),
                "Arrays should be the same"
        );
    }

    @Test
    @DisplayName("Iterable Equals")
    void testIterableEquals() {
        List<String> theList = List.of("luv", "2", "code");
        assertIterableEquals(
                theList,
                demoUtils.getAcademyInList(),
                "Should be the same list"
        );
    }

    @Test
    @DisplayName("Lines Match")
    void testLineMatch() {
        List<String> theList = List.of("luv", "2", "code");
        assertLinesMatch(
                theList,
                demoUtils.getAcademyInList(),
                "List should match"
        );
    }

    @Test
    @DisplayName("Throws & doesn't throw")
    void testThrowsAndDoesNotThrow() {
        assertThrows(
                Exception.class,
                () -> { demoUtils.throwException(-1); },
                "Should throw exception"
        );
        assertDoesNotThrow(
                () -> { demoUtils.throwException(5); },
                "Should not throw exception"
        );
    }

    @Test
    @DisplayName("Timeout")
    // @Order(1)
    void testTimeout() {
        assertTimeout(
                Duration.ofSeconds(3),
                () -> { demoUtils.checkTimeout(); },
                "Should execute in 3 seconds"
        );
    }
    /*
    @BeforeAll
    static void setupBeforeEachClass() {
        System.out.println("Executes before all test methods");
    }

    @AfterAll
    static void tearDownAfterAll() {
        System.out.println("Executes after all test methods");
    }

    @AfterEach
    void tearDownAfterEach() {
        System.out.println("Executes after each test case");
    }
    */
}