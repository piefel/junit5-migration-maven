package example.jupiter

import org.junit.jupiter.api.Assertions.assertEquals

import example.Calculator
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class KotlinBasedTest {

    val calculator = Calculator()

    @Test
    @DisplayName("Test using @DisplayName annotation")
    fun test() {
        assertEquals(2, calculator.add(1, 1), "1 + 1 should equal 2")
    }

    @Test
    fun `Test using built-in method name`() {
        assertEquals(3, calculator.add(1, 2), "1 + 2 should equal 3")
    }

}
