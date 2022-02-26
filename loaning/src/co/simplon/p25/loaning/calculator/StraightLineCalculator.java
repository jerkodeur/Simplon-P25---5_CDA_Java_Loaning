/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * The straight-line calculator concrete implementation.
 */
public class StraightLineCalculator extends AbstractCalculator {
    private final double principal;
    private double interests;
    private double remaining;

    /**
     * Creates a new StraightLineCalculator.
     *
     * @param request - the schedule request
     * @throws NullPointerException
     */
    public StraightLineCalculator(Request request) {
	super(request);
	principal = Double.valueOf(amount / periods);
	remaining = amount;
    }

    /**
     * Example 2 input: a=100000 d=1 r=1.2 m=STRAIGHT_LINE
     */
    @Override
    public Schedule calculate() {
	// Invoking firstPeriod(Builder) once
	Payment.Builder firstPayment = new Payment.Builder();
	Payment firstPeriod = firstPeriod(firstPayment).build();
	System.out.println("First period");
	System.out.println(firstPayment.build().toString());
	// Initialize a new Schedule instance
	Schedule schedule = new Schedule.Builder().add(firstPeriod).interests(firstPeriod.getInterests())
		.total(firstPeriod.getTotal()).build();
	System.out.println("Payments");
	System.out.println(schedule.getPayments());
	// Invoking nextPeriod(Payment, Builder) method as many times as there are
	// remaining periods in order.
	int boucle = 0;
	while (remaining() - principal > 0) {
	    boucle++;
	    if (remaining > principal) {
		remaining -= principal;
	    }
	    System.out.println(boucle + " " + remaining);
	    // invoking nextPeriod
//	    Payment nextPeriod = new Payment();
//	    Schedule.Builder sch =  new Schedule.Builder()
//	    schedule.Builder.add(secondPeriod);
	}
	return null;
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
	setInterest(amount);
	remaining();
	return builder.interests(interests).principal(principal).remaining(remaining()).total(total());
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
	// TODO Auto-generated method stub
	return null;
    }

    protected void setInterest(double amount) {
	interests = amount * (decimalPeriodicRate() / 100);
    }

    private double total() {
	return principal + interests;
    }

    private double remaining() {
	return remaining - principal;
    }

}
