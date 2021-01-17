package ua.com.foxminded.division;

import com.google.gson.Gson;
import ua.com.foxminded.division.model.DivisionResult;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;

public class BaseTest {

    private static final Path TEST_RESOURCES_PATH = Path.of("src/test/resources");
    private static final Gson gson = new Gson();

    protected DivisionResult getResultFromFile(int dividend, int divisor) {
        String fileName = String.format("%d_%d.json", dividend, divisor);
        Path filePath = TEST_RESOURCES_PATH.resolve(fileName);
        try (Reader reader = Files.newBufferedReader(filePath)) {
            return gson.fromJson(reader, DivisionResult.class);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
