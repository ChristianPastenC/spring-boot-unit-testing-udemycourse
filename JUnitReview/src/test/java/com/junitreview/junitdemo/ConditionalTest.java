package com.junitreview.junitdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.*;

class ConditionalTest {
    @Test
    @DisplayName("Don't run until JIRA #123 is resolved")
    void basicTest() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnOs(OS.WINDOWS)
    void testForWindowsOnly() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnOs(OS.MAC)
    void testForMacOnly() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnOs({OS.MAC, OS.WINDOWS})
    void testForMacAndWindowsOnly() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnOs(OS.LINUX)
    void testForLinuxOnly() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnJre(JRE.JAVA_18)
    void testForJava17Only() {
        // execute method and perform assets
    }

    @Test
    @EnabledOnJre(JRE.JAVA_11)
    void testForJava11Only() {
        // execute method and perform assets
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11, max=JRE.JAVA_18)
    void testForJavaRange() {
        // execute method and perform assets
    }

    @Test
    @EnabledForJreRange(min=JRE.JAVA_11)
    void testForJavaRangeMin() {
        // execute method and perform assets
    }
}