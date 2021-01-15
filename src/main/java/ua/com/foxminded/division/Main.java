package ua.com.foxminded.division;

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
        int dividend = 78945;
        int divisor = 4;

        Context context = Context.newInstance(args);

        Divider divider = context.getDivider();
        DivisionResult result = divider.divide(dividend, divisor);

        Formatter formatter = context.getFormatter();
        String output = formatter.format(result);

        System.out.println(output);
    }

}
