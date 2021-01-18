package ua.com.foxminded.division.ioc;

import ua.com.foxminded.division.exception.BadArgsException;
import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.math.IntegerDivider;
import ua.com.foxminded.division.text.ClassicFormatter;
import ua.com.foxminded.division.text.Formatter;

public class Context {

    private Divider divider;
    private Formatter formatter;

    private Parameters params;

    private Context() { }

    public static Context newInstance(String[] args) {
        Context ctx = new Context();
        ctx.divider = new IntegerDivider();
        ctx.formatter = new ClassicFormatter();
        ctx.params = Parameters.parse(args);

        return ctx;
    }

    public Divider getDivider() {
        return divider;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public int getDividend() {
        return params.dividend;
    }

    public int getDivisor() {
        return params.divisor;
    }

    private static class Parameters {

        private int dividend;
        private int divisor;

        public static Parameters parse(String[] args) {
            if (args == null || args.length != 2) {
                throw new BadArgsException("Expected exactly two arguments");
            }

            Parameters params = new Parameters();
            try {
                params.dividend = Integer.parseInt(args[0]);
                params.divisor = Integer.parseInt(args[1]);

            } catch (NumberFormatException e) {
                throw new BadArgsException("Parameters should be integers");
            }
            if (params.dividend < 0 || params.divisor < 0) {
                throw new BadArgsException("Negative numbers are not allowed");
            }
            if (params.divisor == 0) {
                throw new BadArgsException("Divisor can not be zero");
            }
            return params;
        }

        public int getDividend() {
            return dividend;
        }

        public int getDivisor() {
            return divisor;
        }
    }
}
