package example.jupiter;

import example.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class TestsWithParameters {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
//    @ValueSource(ints = { 4, 5, 6 })
    @MethodSource("sumStream")
    void filteringCalculator(int expectedResult) {
        assumingThat(() -> expectedResult % 2 == 1, () -> {
            int actualResult = calculator.add(2, 3);
            assertEquals(expectedResult, actualResult);
        });
    }

    private static IntStream sumStream() {
        return IntStream.rangeClosed(4, 6);
    }

    @DisplayName("Adding numbers")
    @ParameterizedTest(name = "{index} --> {0} + {1} == {2}")
//    @CsvSource({"2, 3, 5", "4, 5, 9"})
    @MethodSource("sumArray")
    void realAdder(int summand1, int summand2, int expectedResult) {
        int actualResult = calculator.add(summand1, summand2);
        assertEquals(expectedResult, actualResult);
    }

    private static Object[][] sumArray() {
        return new Object[][] { { 2, 3, 5}, { 4, 5, 9 } };
    }

}
