package ua.com.foxminded.division.generator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.foxminded.division.math.IntegerDivider;
import ua.com.foxminded.division.model.DivisionResult;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;

public class TestCaseGenerator {

    private final static Path TEST_RESOURCES_PATH = Path.of("src/test/resources");
    private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final static IntegerDivider divider = new IntegerDivider();

    private static void generateTestCase(int dividend, int divisor, String fileName) {
        DivisionResult result = divider.divide(dividend, divisor);
        Path filePath = TEST_RESOURCES_PATH.resolve(fileName);
        try (Writer writer = Files.newBufferedWriter(filePath)) {
            gson.toJson(result, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateTestCase(int dividend, int divisor) {
        String fileName = String.format("%d_%d.json", dividend, divisor);
        generateTestCase(dividend, divisor, fileName);
    }

    public static void main(String[] args){
        generateTestCase(78945, 4);
        generateTestCase(630440, 610);
        generateTestCase(12341234, 1234);
    }
}
