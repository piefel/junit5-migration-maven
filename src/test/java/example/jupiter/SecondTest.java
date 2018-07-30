/*
 * Copyright 2015-2018 the original author or authors.
 *
 * All rights reserved. This program and the accompanying materials are
 * made available under the terms of the Eclipse Public License v2.0 which
 * accompanies this distribution and is available at
 *
 * http://www.eclipse.org/legal/epl-v20.html
 */

package example.jupiter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import example.Calculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;

class SecondTest {

    private Calculator calculator;

    @BeforeEach
    void setup(TestReporter testReporter) {
        testReporter.publishEntry("@BeforeEach", "create calculator");
        calculator = new Calculator();
    }

    @Test
    @DisplayName("My 1st cool JUnit 5 test!")
    void myFirstTest(TestInfo testInfo) {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2");
        assertEquals("My 1st cool JUnit 5 test!", testInfo.getDisplayName(),
                () -> "TestInfo is injected correctly");
    }

    @Test
    @Disabled
    void mySecondTest() {
        assertEquals(2, 1, "2 is not equal to 1");
    }

    @Test
    @Tag("slow")
    void aVerySlowTest() throws InterruptedException {
        Thread.sleep(5000);
    }
}
