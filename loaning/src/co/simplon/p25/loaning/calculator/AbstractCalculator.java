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
    protected double amount;
    protected double rate;
    protected int periods;
    protected double remaining;
    protected double interests;
    protected double principal;

    /**
     * Creates a new AbstractCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException - if the request is null
     */
    public AbstractCalculator(Request request) throws NullPointerException {
	if (request == null) {
	    throw new NullPointerException("Error: The request cannot be null!");
	}

	amount = request.getAmount();
	rate = request.getRate();
	periods = request.getDuration() * 12;
    }

    /**
     * The algorithm skeleton takes care of building the Schedule, invoking
     * firstPeriod(Builder) once, then nextPeriod(Payment, Builder) method as many
     * times as there are remaining periods in order to build the Payments. The
     * template method calculates the schedule's total interests and total paid.
     *
     * @return The calculated schedule, never null
     */
    @Override
    public abstract Schedule calculate();

    /**
     * Utility method for sub-classes returning the requested loan amount.
     *
     * @return the loan amount
     */
    protected final double amount() {
	return amount;
    }

    /**
     * Utility method for sub-classes returning the requested number of periods in
     * months
     *
     * @return the number of periods in months
     */
    protected final int periods() {
	return periods;
    }

    /**
     * Utility method for sub-classes returning the periodic (monthly) percent
     * annual rate converted to a decimal.
     *
     * @return the percent rate as a decimal
     */
    protected final double decimalPeriodicRate() {
	return Double.valueOf(rate / periods);
    }

    protected final void setInterests(double amount) {
	interests = amount * decimalPeriodicRate() / 100;
    }

    protected final void setRemaining(double amount) {
	remaining = amount - principal;
    }

    /**
     * Calculates the first period (month) of the schedule.
     *
     * @param builder - a payment builder to set calculated payment values
     * @return the updated builder itself
     */
    protected abstract Payment.Builder firstPeriod(Payment.Builder builder);

    /**
     * Calculates the next period(s) (month-s) of the schedule.
     *
     * @param previous - the previously calculated payment
     * @param builder  - a payment builder to set calculated payment values
     * @return the updated builder with calculated values
     */
    protected abstract Payment.Builder nextPeriod(Payment previous, Payment.Builder builder);
}
