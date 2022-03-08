/**
 *
 */
package co.simplon.p25.loaning.calculator;

import co.simplon.p25.loaning.calculator.Payment.Builder;

/**
 * The annuity calculator concrete implementation.
 *
 */
final class AnnuityCalculator extends AbstractCalculator {

    /**
     * Creates a new AnnuityCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException - if the request is null
     */
    AnnuityCalculator(Request request) {
	super(request);
	setRemaining(amount);
	setInterests(remaining);
	setTotal();
    }

    /**
     * Calculate and set current schedule principal.
     */
    final void setPrincipal() {
	principal = total - interests;
    }

    @Override
    final void setTotal() {
	double percentRate = decimalPeriodicRate() / 100;
	total = remaining
		* (percentRate * (Math.pow(1 + percentRate, periods) / (Math.pow(1 + percentRate, periods) - 1)));
    }

    /**
     * Calculates the first period (month) based on the annuity method.
     * <p>
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param builder - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    Builder firstPeriod(Payment.Builder builder) {
	setPrincipal();
	setRemaining(remaining);
	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

    /**
     * Calculates a next period (month) based on the annuity method.
     * <p>
     * Calculates the principal, interests, total paid and remaining for the period.
     *
     * @param previous - the previously calculated payment
     * @param builder  - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    Builder nextPeriod(Payment previous, Payment.Builder builder) {
	setInterests(previous.getRemaining());
	setPrincipal();
	setRemaining(previous.getRemaining());

	return builder.interests(interests).principal(principal).remaining(remaining).total(total);
    }

}
