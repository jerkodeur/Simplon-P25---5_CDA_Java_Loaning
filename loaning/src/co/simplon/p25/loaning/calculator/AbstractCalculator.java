/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * An abstract calculator implementing the calculate() method as a template
 * method.
 *
 */
abstract class AbstractCalculator implements Calculator {
    protected double amount;
    protected int periods;
    protected double rate;
    protected double principal;
    protected double interests;
    protected double total;
    protected double remaining;

    /**
     * Creates a new AbstractCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException if the request is null
     */
    AbstractCalculator(Request request) throws NullPointerException {
	if (request == null) {
	    throw new NullPointerException("Error: The request cannot be null!");
	}

	amount = request.getAmount();
	periods = request.getDuration() * 12;
	rate = request.getRate();
    }

    /**
     * Template method implementing the algorithm skeleton, and delegating specific
     * calculation to sub-classes.
     * <p>
     * The algorithm skeleton takes care of building the Schedule, invoking
     * firstPeriod(Builder) once, then nextPeriod(Payment, Builder) method as many
     * times as there are remaining periods in order to build the Payments. <br>
     * The template method calculates the schedule's total interests and total paid.
     *
     * @return the calculated schedule, never null
     */
    @Override
    public final Schedule calculate() {
	// Invoking firstPeriod(Builder) once
	Payment.Builder paymentBuilder = new Payment.Builder();
	Payment payment = firstPeriod(paymentBuilder).build();
	// Initialize a new Schedule instance with the first period
	Schedule.Builder builder = new Schedule.Builder().add(payment).interests(interests).total(total);
	// Add each next period to the schedule instance
	while (remaining - principal > 0) {
	    Payment.Builder nextPaymentBuilder = new Payment.Builder();
	    Payment nextPayment = nextPeriod(payment, nextPaymentBuilder).build();
	    builder.add(nextPayment).interests(nextPayment.getInterests()).total(nextPayment.getTotal());

	    payment = nextPayment;
	}

	return builder.build();
    }

    /**
     * Utility method for sub-classes returning the requested loan amount.
     *
     * @return the loan amount
     */
    final double amount() {
	return amount;
    }

    /**
     * Utility method for sub-classes returning the requested number of periods in
     * months.
     *
     * @return the number of periods in months
     */
    final int periods() {
	return periods;
    }

    /**
     * Utility method for sub-classes returning the periodic (monthly) percent
     * annual rate converted to a decimal.
     *
     * @return the percent rate as a decimal
     */
    final double decimalPeriodicRate() {
	return Double.valueOf(rate / periods);
    }

    /**
     * Calculate and set current schedule interests.
     *
     * @param amount - the amount on which calculate interest
     */
    final void setInterests(double amount) {
	interests = amount * decimalPeriodicRate() / 100;
    }

    /**
     * Calculate and set current schedule remaining balance.
     *
     * @param amount - the amount on which calculate remaining balance
     */
    final void setRemaining(double amount) {
	remaining = amount - principal;
    }

    /**
     * Calculate and set current schedule total.
     */
    abstract void setTotal();

    /**
     * Calculates the first period (month) of the schedule.
     *
     * @param builder - a payment builder to set calculated payment values
     * @return the updated builder itself
     */
    abstract Payment.Builder firstPeriod(Payment.Builder builder);

    /**
     * Calculates the next period(s) (month-s) of the schedule.
     *
     * @param previous - the previously calculated payment
     * @param builder  - a payment builder to set calculated payment values
     * @return the updated builder itself
     */
    abstract Payment.Builder nextPeriod(Payment previous, Payment.Builder builder);
}
