package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.DivisionResult;

public class ClassicFormatter implements Formatter {
    @Override
    public String format(DivisionResult result) {
        return result.toString();
    }
}
