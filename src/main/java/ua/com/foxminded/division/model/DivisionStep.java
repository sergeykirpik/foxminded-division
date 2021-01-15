package ua.com.foxminded.division.model;

import java.text.MessageFormat;
import java.util.Objects;

public class DivisionStep {

    private final int dividend;
    private final int integralDividend;
    private final int quotient;
    private final int remainder;

    public DivisionStep(int dividend, int integralDividend, int quotient, int remainder) {
        this.dividend = dividend;
        this.integralDividend = integralDividend;
        this.quotient = quotient;
        this.remainder = remainder;
    }

    public int getDividend() {
        return dividend;
    }

    public int getIntegralDividend() {
        return integralDividend;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    @Override
    public String toString() {
        return MessageFormat.format("Step'{'quotient={0}, dividend={1}, integralDividend={2}, remainder={3}'}'\n",
                quotient, dividend, integralDividend, remainder);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionStep that = (DivisionStep) o;
        return dividend == that.dividend && integralDividend == that.integralDividend && quotient == that.quotient && remainder == that.remainder;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, integralDividend, quotient, remainder);
    }
}
