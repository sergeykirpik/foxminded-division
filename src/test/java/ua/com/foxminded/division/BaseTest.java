package ua.com.foxminded.division;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import org.junit.jupiter.params.provider.Arguments;
import ua.com.foxminded.division.model.DivisionResult;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class BaseTest {

    private static final Path TEST_RESOURCES_PATH = Path.of("src/test/resources");
    private static final Gson gson = new Gson();

    static Stream<Arguments> provideArgsForTests() {
        return Stream.of(
                Arguments.of(78945, 4),
                Arguments.of(630440, 610),
                Arguments.of(12341234, 1234)
        );
    }

    protected DivisionResult loadDivisionResultFromFile(String fileName) {
        Path filePath = TEST_RESOURCES_PATH.resolve(fileName);
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return gson.fromJson(reader, DivisionResult.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected String loadStringFromFile(String fileName) {
        Path filePath = TEST_RESOURCES_PATH.resolve(fileName);
        try {
            return Files.readString(filePath, Charsets.UTF_8);

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
