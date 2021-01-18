package ua.com.foxminded.division.ioc;

import org.junit.jupiter.api.Test;
import ua.com.foxminded.division.exception.BadArgsException;

import static org.junit.jupiter.api.Assertions.*;

public class ContextTest {

    public static final String[] DEFAULT_ARGS = new String[]{ "1", "1" };

    @Test
    void newInstance_shouldCreateContext() {
        Context ctx = Context.newInstance(DEFAULT_ARGS);
        assertNotNull(ctx);
    }

    @Test
    void newInstance_shouldCreateContextWithDividerAndFormatter() {
        Context ctx = Context.newInstance(DEFAULT_ARGS);
        assertNotNull(ctx.getDivider());
        assertNotNull(ctx.getFormatter());
    }

    @Test
    void newInstance_shouldParseCorrectArgs() {
        String[] args = new String[]{ "745", "15" };
        Context ctx = Context.newInstance(args);
        assertEquals(745, ctx.getDividend());
        assertEquals(15, ctx.getDivisor());
    }

    @Test
    void newInstance_shouldThrow_whenArgsIsNull() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(null));
    }

    @Test
    void newInstance_shouldThrow_whenArgsCountNotEqual2() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[0]));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "745" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "1", "2", "3" }));
    }

    @Test
    void newInstance_shouldThrow_whenArgsIsNotIntegers() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "one", "2" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "1", "two" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "1.4", "2" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "1", "2.5" }));
    }

    @Test
    void newInstance_shouldThrow_whenNumbersIsTooBig() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "9999999999", "2" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "2", "9999999999" }));
    }

    @Test
    void newInstance_shouldThrow_whenNegativeNumbers() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "-4", "2" }));
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "20", "-9" }));
    }

    @Test
    void newInstance_shouldThrow_whenDivisorIsZero() {
        assertThrows(BadArgsException.class,
                () -> Context.newInstance(new String[]{ "200", "0" }));
    }

}
