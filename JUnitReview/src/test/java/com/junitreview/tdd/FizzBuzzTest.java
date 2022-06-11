package com.junitreview.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {
    // If number is divisible by 3, print Fuzz
    @Test
    @DisplayName("Divisible by 3")
    @Order(1)
    void testForDivisibleByThree(){
        String expected = "Fizz";
        assertEquals(expected, FizzBuzz.compute(3), "Should return Fizz");
    }

    // If number is divisible by 5, print Buzz
    @Test
    @DisplayName("Divisible by 5")
    @Order(2)
    void testForDivisibleByFive(){
        String expected = "Buzz";
        assertEquals(expected, FizzBuzz.compute(5), "Should return Buzz");
    }

    // If number is divisible by 3 and 5 (15), print FizBuzz
    @Test
    @DisplayName("Divisible by 3 & 5")
    @Order(3)
    void testForDivisibleByThreeAndFive(){
        String expected = "FizzBuzz";
        assertEquals(expected, FizzBuzz.compute(15), "Should return FizzBuzz");
    }

    // If number is NOT divisible by 3 or 5, then print the number
    @Test
    @DisplayName("Not Divisible by 3 or 5")
    @Order(4)
    void testForNotDivisibleByThreeOrFive(){
        String expected = "1";
        assertEquals(expected, FizzBuzz.compute(1), "Should return 1");
    }

    @DisplayName("Testing with small data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(5)
    void testSmallDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with medium data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testMediumDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with large data file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(7)
    void testLargeDataFile(int value, String expected){
        assertEquals(expected, FizzBuzz.compute(value));
    }
}
