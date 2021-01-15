package ua.com.foxminded.division.model;

import java.util.Arrays;
import java.util.Objects;

public class DivisionResult {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final DivisionStep[] steps;

    public DivisionResult(int dividend, int divisor, int quotient, int remainder, DivisionStep[] steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;
        this.steps = steps;
    }

    public int getDividend() {
        return dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public int getRemainder() {
        return remainder;
    }

    public DivisionStep[] getSteps() {
        return Arrays.copyOf(steps, steps.length);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionResult that = (DivisionResult) o;
        return dividend == that.dividend && divisor == that.divisor && quotient == that.quotient && remainder == that.remainder && Arrays.equals(steps, that.steps);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(dividend, divisor, quotient, remainder);
        result = 31 * result + Arrays.hashCode(steps);
        return result;
    }

    @Override
    public String toString() {
        return "DivisionResult{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                ", quotient=" + quotient +
                ", remainder=" + remainder +
                ", steps=" + Arrays.toString(steps) +
                '}';
    }
}
