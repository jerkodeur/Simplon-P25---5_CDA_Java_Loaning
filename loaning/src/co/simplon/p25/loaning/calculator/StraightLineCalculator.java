/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * The straight-line calculator concrete implementation.
 */
public class StraightLineCalculator extends AbstractCalculator {

    /**
     * Creates a new StraightLineCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException
     */
    StraightLineCalculator(Request request) {
	super(request);
	principal = Double.valueOf(amount / periods);
	setRemaining(amount);
	setInterests(amount);
	setTotal();
    }

    @Override
    final void setTotal() {
	total = principal + interests;
    }

    /**
     * Calculates the first period (month) based on the straight-line method.
     * <p>
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param builder - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    Payment.Builder firstPeriod(Payment.Builder builder) {
	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

    /**
     * Calculates a next period (month) based on the straight-line method.
     * <p>
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param previous - the previously calculated payment
     * @param builder  - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    Payment.Builder nextPeriod(Payment previous, Payment.Builder builder) {
	setInterests(previous.getRemaining());
	setRemaining(previous.getRemaining());
	setTotal();

	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }
}
