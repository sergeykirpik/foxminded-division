package ua.com.foxminded.division.math;

import ua.com.foxminded.division.model.DivisionResult;
import ua.com.foxminded.division.model.DivisionStep;

import java.util.ArrayList;
import java.util.List;

public class IntegerDivider implements Divider {

    public DivisionResult divide(int dividend, int divisor) {

        String dividendStr = String.valueOf(dividend);
        int digitsInDividend = dividendStr.length();
        List<DivisionStep> steps = new ArrayList<>();
        int remainder = 0;
        int quotient = 0;

        for (int i = 0; i < digitsInDividend; i++) {
            int nextDigit = Character.digit(dividendStr.charAt(i), 10);
            int partialDividend = remainder * 10 + nextDigit;

            DivisionStep step = doOneStep(partialDividend, divisor);
            remainder = step.getRemainder();
            quotient = quotient * 10 + step.getQuotient();

            if (!steps.isEmpty() || step.getQuotient() != 0) {
                steps.add(step);
            }
        }

        return new DivisionResult(dividend, divisor, quotient, remainder, steps);
    }

    private static DivisionStep doOneStep(int dividend, int divisor) {
        int quotient = 9;
        int integralDividend = quotient * divisor;
        while (integralDividend > dividend && quotient > 0) {
            quotient--;
            integralDividend = divisor * quotient;
        }
        int remainder = dividend - integralDividend;

        return new DivisionStep(dividend, integralDividend, quotient, remainder);
    }

}
