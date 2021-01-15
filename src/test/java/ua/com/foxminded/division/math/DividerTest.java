package ua.com.foxminded.division.math;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.model.DivisionResult;
import ua.com.foxminded.division.model.DivisionStep;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DividerTest {

    private Divider underTest;

    @BeforeEach
    void setup() {
        underTest = new Divider();
    }

    @Test
    void test1() {
        int dividend = 78945;
        int divisor = 4;
        int quotient = 19736;
        int remainder = 1;
        DivisionStep[] steps = new DivisionStep[] {
                new DivisionStep(7, 4, 1, 3),
                new DivisionStep(38, 36, 9, 2),
                new DivisionStep(29, 28, 7, 1),
                new DivisionStep(14, 12, 3, 2),
                new DivisionStep(25, 24, 6, 1)};

        DivisionResult expected = new DivisionResult(dividend, divisor, quotient, remainder, steps);

        DivisionResult actual = underTest.divide(dividend, divisor);

        assertEquals(expected, actual);
    }

    @Test
    void test2() {
        int dividend = 630440;
        int divisor = 610;
        int quotient = 1033;
        int remainder = 310;
        DivisionStep[] steps = new DivisionStep[] {
                new DivisionStep(6, 0, 0, 6),
                new DivisionStep(63, 0, 0, 63),
                new DivisionStep(630, 610, 1, 20),
                new DivisionStep(204, 0, 0, 204),
                new DivisionStep(2044, 1830, 3, 214),
                new DivisionStep(2140, 1830, 3, 310)};

        DivisionResult expected = new DivisionResult(dividend, divisor, quotient, remainder, steps);

        DivisionResult actual = underTest.divide(dividend, divisor);

        assertEquals(expected, actual);
    }

    @Test
    void test3() {
        int dividend = 12341234;
        int divisor = 1234;
        int quotient = 10001;
        int remainder = 0;
        DivisionStep[] steps = new DivisionStep[] {
                new DivisionStep(1, 0, 0, 1),
                new DivisionStep(12, 0, 0, 12),
                new DivisionStep(123, 0, 0, 123),
                new DivisionStep(1234, 1234, 1, 0),
                new DivisionStep(1, 0, 0, 1),
                new DivisionStep(12, 0, 0, 12),
                new DivisionStep(123, 0, 0, 123),
                new DivisionStep(1234, 1234, 1, 0)};

        DivisionResult expected = new DivisionResult(dividend, divisor, quotient, remainder, steps);

        DivisionResult actual = underTest.divide(dividend, divisor);

        assertEquals(expected, actual);
    }
}
