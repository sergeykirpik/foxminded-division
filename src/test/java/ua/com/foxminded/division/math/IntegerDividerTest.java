package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.foxminded.division.BaseTest;
import ua.com.foxminded.division.model.DivisionResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegerDividerTest extends BaseTest {

    private Divider underTest;

    @BeforeEach
    void setup() {
        underTest = new IntegerDivider();
    }

    @Test
    void divide_shouldReturnCorrectQuotientAndRemainder() {
        DivisionResult result = underTest.divide(13, 4);
        assertEquals(3, result.getQuotient());
        assertEquals(1, result.getRemainder());
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
