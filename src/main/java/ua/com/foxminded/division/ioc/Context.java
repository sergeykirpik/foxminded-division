package ua.com.foxminded.division.ioc;

import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.text.Formatter;
import ua.com.foxminded.division.text.JsonFormatter;

public class Context {

    private Divider divider;
    private Formatter formatter;

    private Context() { }

    public static Context newInstance(String[] args) {
        Context context = new Context();
        context.divider = new Divider();
        context.formatter = new JsonFormatter();

        return context;
    }

    public Divider getDivider() {
        return divider;
    }

    public Formatter getFormatter() {
        return formatter;
    }
}
