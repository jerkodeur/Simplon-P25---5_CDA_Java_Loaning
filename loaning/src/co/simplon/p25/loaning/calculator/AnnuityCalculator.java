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

    /**
     * Creates a new AnnuityCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException
     */
    public AnnuityCalculator(Request request) {
	super(request);
	System.out.println(periods());
    }

    @Override
    public Schedule calculate() {
	// TODO Auto-generated method stub
	return null;
    }

    /**
     * Calculates the first period (month) based on the annuity method. Calculates
     * the principal, interests, total paid and remaining for the period.
     *
     * @param builder - the payment builder
     * @return the updated builder with calculated values
     */
    @Override
    Builder firstPeriod(Builder builder) {
	// TODO Auto-generated method stub
	return null;
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
    Builder nextPeriod(Payment previous, Builder builder) {
	// TODO Auto-generated method stub
	return null;
    }

}
