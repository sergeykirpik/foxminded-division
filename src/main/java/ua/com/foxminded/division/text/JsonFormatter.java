package ua.com.foxminded.division.text;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ua.com.foxminded.division.model.DivisionResult;

public class JsonFormatter implements Formatter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public String format(DivisionResult result) {
        return gson.toJson(result);
    }
}
