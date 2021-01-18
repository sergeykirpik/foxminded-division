package ua.com.foxminded.division;

import ua.com.foxminded.division.exception.BadArgsException;
import ua.com.foxminded.division.ioc.Context;
import ua.com.foxminded.division.math.Divider;
import ua.com.foxminded.division.model.DivisionResult;
import ua.com.foxminded.division.text.Formatter;

/**
 * Integer Division
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        if (args.length != 2) {
            System.out.println("\nUsage: division [dividend] [divisor]\n");
            System.exit(1);
        }

        Context ctx = null;
        try {
            ctx = Context.newInstance(args);
        } catch (BadArgsException e) {
            System.out.println();
            System.out.println(e.getMessage());
            System.out.println();
            System.exit(1);
        }

        Divider divider = ctx.getDivider();
        DivisionResult result = divider.divide(ctx.getDividend(), ctx.getDivisor());

        Formatter formatter = ctx.getFormatter();
        String output = formatter.format(result);

        System.out.println();
        System.out.println(output);
        System.out.println();
    }

}
