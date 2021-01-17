package ua.com.foxminded.division.model;

import java.util.*;

public class DivisionResult {
    private final int dividend;
    private final int divisor;
    private final int quotient;
    private final int remainder;
    private final List<DivisionStep> steps = new ArrayList<>();

    public DivisionResult(int dividend, int divisor, int quotient, int remainder, Iterable<DivisionStep> steps) {
        this.dividend = dividend;
        this.divisor = divisor;
        this.quotient = quotient;
        this.remainder = remainder;

        steps.forEach(this.steps::add);
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
        return steps.toArray(new DivisionStep[0]);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DivisionResult that = (DivisionResult) o;
        return dividend == that.dividend &&
               divisor == that.divisor &&
               quotient == that.quotient &&
               remainder == that.remainder &&
               steps.equals(that.steps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dividend, divisor, quotient, remainder, steps);
    }

    @Override
    public String toString() {
        return "DivisionResult{" +
                "dividend=" + dividend +
                ", divisor=" + divisor +
                ", quotient=" + quotient +
                ", remainder=" + remainder +
                ", steps=" + steps +
                '}';
    }
}
