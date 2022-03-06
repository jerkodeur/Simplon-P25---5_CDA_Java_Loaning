/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * The straight-line calculator concrete implementation.
 */
public class StraightLineCalculator extends AbstractCalculator {
    private double total;

    /**
     * Creates a new StraightLineCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException
     */
    public StraightLineCalculator(Request request) {
	super(request);
	principal = Double.valueOf(amount / periods);
	setInterests(amount);
	setRemaining(amount);
	setTotal();
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

    /**
     * Calculates the first period (month) based on the straight-line method.
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param builder - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    protected Payment.Builder firstPeriod(Payment.Builder builder) {
	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

    /**
     * Calculates a next period (month) based on the straight-line method.
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param previous - the previously calculated payment
     * @param builder  - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    protected Payment.Builder nextPeriod(Payment previous, Payment.Builder builder) {
	setInterests(previous.getRemaining());
	setRemaining(previous.getRemaining());
	setTotal();

	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

    protected void setTotal() {
	total = principal + interests;
    }

}
