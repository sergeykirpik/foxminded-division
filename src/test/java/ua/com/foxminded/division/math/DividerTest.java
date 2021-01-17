package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.foxminded.division.BaseTest;
import ua.com.foxminded.division.model.DivisionResult;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DividerTest extends BaseTest {

    private Divider underTest;

    @BeforeEach
    void setup() {
        underTest = new Divider();
    }

    private static Stream<Arguments> provideArgsForDividerTest() {
        return Stream.of(
                Arguments.of(78945, 4),
                Arguments.of(630440, 610),
                Arguments.of(12341234, 1234)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgsForDividerTest")
    void doTest(int dividend, int divisor) {
        DivisionResult expected = getResultFromFile(dividend, divisor);
        DivisionResult actual = underTest.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

}
