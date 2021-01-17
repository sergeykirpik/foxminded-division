package ua.com.foxminded.division.math;

import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import ua.com.foxminded.division.model.DivisionResult;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DividerTest {

    private static final Path TEST_RESOURCES_PATH = Path.of("src/test/resources");

    private static final Gson gson = new Gson();
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

    private DivisionResult getResultFromFile(int dividend, int divisor) {
        String fileName = String.format("%d_%d.json", dividend, divisor);
        Path filePath = TEST_RESOURCES_PATH.resolve(fileName);
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return gson.fromJson(reader, DivisionResult.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
