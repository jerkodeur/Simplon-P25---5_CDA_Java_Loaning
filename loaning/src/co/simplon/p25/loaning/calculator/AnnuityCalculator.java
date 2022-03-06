/**
 *
 */
package co.simplon.p25.loaning.calculator;

import co.simplon.p25.loaning.calculator.Payment.Builder;

/**
 * The annuity calculator concrete implementation.
 *
 */
public final class AnnuityCalculator extends AbstractCalculator {
    private final double total;

    /**
     * Creates a new AnnuityCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException
     */
    public AnnuityCalculator(Request request) {
	super(request);
	remaining = amount;
	total = getCalculateTotal();
	setInterests(remaining);
	setPrincipal();
    }

    @Override
    public Schedule calculate() {
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

    private void setPrincipal() {
	principal = total - interests;
    }

    protected double getCalculateTotal() {
	double percentRate = decimalPeriodicRate() / 100;
	return remaining
		* (percentRate * (Math.pow(1 + percentRate, periods) / (Math.pow(1 + percentRate, periods) - 1)));
    }

    /**
     * Calculates the first period (month) based on the annuity method. Calculates
     * the principal, interests, total paid and remaining for the period.
     *
     * @param builder - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    public Builder firstPeriod(Builder builder) {
	setRemaining(remaining);
	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

    /**
     * Calculates a next period (month) based on the annuity method. Calculates the
     * principal, interests, total paid and remaining for the period.
     *
     * @param previous - the previously calculated payment
     * @param builder  - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    public Builder nextPeriod(Payment previous, Builder builder) {
	setInterests(previous.getRemaining());
	setPrincipal();
	setRemaining(previous.getRemaining());

	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

}
