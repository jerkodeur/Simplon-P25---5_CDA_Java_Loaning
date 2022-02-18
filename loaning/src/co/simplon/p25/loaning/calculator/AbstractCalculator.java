/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * An abstract calculator implementing the calculate() method as a template
 * method.
 *
 */
public abstract class AbstractCalculator implements Calculator {

    @Override
    /**
     * The algorithm skeleton takes care of building the Schedule, invoking
     * firstPeriod(Builder) once, then nextPeriod(Payment, Builder) method as many
     * times as there are remaining periods in order to build the Payments. The
     * template method calculates the schedule's total interests and total paid.
     *
     * @return The calculated schedule, never null
     */
    public abstract Schedule calculate();

}
