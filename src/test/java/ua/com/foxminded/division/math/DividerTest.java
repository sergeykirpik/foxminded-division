package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.foxminded.division.BaseTest;
import ua.com.foxminded.division.model.DivisionResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DividerTest extends BaseTest {

    private Divider underTest;

    @BeforeEach
    void setup() {
        underTest = new Divider();
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTests")
    void divide_shouldReturnCorrectResult(int dividend, int divisor) {
        String fileName = String.format("%d_%d.json", dividend, divisor);
        DivisionResult expected = loadDivisionResultFromFile(fileName);
        DivisionResult actual = underTest.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

}
