package ua.com.foxminded.division.text;

import ua.com.foxminded.division.model.DivisionResult;
import ua.com.foxminded.division.model.DivisionStep;

import java.util.ArrayList;
import java.util.List;

public class ClassicFormatter implements Formatter {

    @Override
    public String format(DivisionResult result) {
        DivisionStep[] steps = result.getSteps();
        if (steps.length == 0) {
            return "";
        }

        List<String> formatted = new ArrayList<>();
        formatted.add("");

        int fieldWidth = digitCount(steps[0].getDividend());

        int currentLine = 0;
        for (DivisionStep step : steps) {
            fieldWidth++;
            if (step.getQuotient() == 0) {
                continue;
            }
            String dividend = padLeft("_" + step.getDividend(), fieldWidth);
            String integralDividend = padLeft(step.getIntegralDividend(), fieldWidth);
            int digitsInIntegralDividend = digitCount(step.getIntegralDividend());
            String dashes = padLeft("-".repeat(digitsInIntegralDividend), fieldWidth);
            String remainder = padLeft(step.getRemainder(), fieldWidth);

            formatted.set(currentLine, dividend);
            formatted.add(integralDividend);
            formatted.add(dashes);
            formatted.add(remainder);
            currentLine += 3;
        }

        int dividend = result.getDividend();
        int divisor = result.getDivisor();
        int quotient = result.getQuotient();

        int digitsInDividend = digitCount(dividend);
        int digitsInDivisor = digitCount(divisor);
        int digitsInQuotient = digitCount(quotient);

        String line0 = String.format("_%d|%d", dividend, divisor);

        String line1 = padRight(formatted.get(1), digitsInDividend + 1);
        int dashesCount = Math.max(digitsInDivisor, digitsInQuotient);
        line1 += "|" + "-".repeat(dashesCount);

        String line2 = padRight(formatted.get(2), digitsInDividend + 1);
        line2 += "|" + quotient;

        formatted.set(0, line0);
        formatted.set(1, line1);
        formatted.set(2, line2);

        return String.join("\n", formatted);
    }

    private <T> String padRight(T obj, int fieldWidth) {
        String str = obj.toString();
        int spacesCount = Math.max(fieldWidth - str.length(), 0);

        return str + " ".repeat(spacesCount);
    }

    private <T> String padLeft(T obj, int fieldWidth) {
        String str = obj.toString();
        int spacesCount = Math.max(fieldWidth - str.length(), 0);

        return " ".repeat(spacesCount) + str;
    }

    private static int digitCount(int number) {
        return String.valueOf(number).length();
    }
}
