package ua.com.foxminded.division.text;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.foxminded.division.BaseTest;
import ua.com.foxminded.division.model.DivisionResult;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassicFormatterTest extends BaseTest {

    private Formatter underTest;

    @BeforeEach
    void setup() {
        underTest = new ClassicFormatter();
    }

    @ParameterizedTest
    @MethodSource("provideArgsForTests")
    void format_shouldReturnCorrectResult(int dividend, int divisor) {
        String formattedFileName = String.format("%d_%d.classic.txt", dividend, divisor);
        String resultFileName = String.format("%d_%d.json", dividend, divisor);
        DivisionResult divisionResult = loadDivisionResultFromFile(resultFileName);

        String expected = loadStringFromFile(formattedFileName);
        String actual = underTest.format(divisionResult);
        assertEquals(expected, actual);
    }
}
