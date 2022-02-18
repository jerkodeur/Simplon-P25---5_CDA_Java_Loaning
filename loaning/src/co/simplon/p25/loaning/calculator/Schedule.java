/**
 *
 */
package co.simplon.p25.loaning.calculator;

import java.util.List;

/**
 * Represents an amortization schedule. Provides a builder in order to help
 * constructing immutable instances.
 */
public final class Schedule {

    private List<Payment> payments;
    private double interests;
    private double total;

    /**
     * A builder to build Schedule instances.
     */
    static final class Builder {

	/**
	 * Builds a new Schedule with specified payments, interests and total.
	 *
	 * @return a new Schedule instance
	 */
	private Schedule build() {
	    return new Schedule();
	}

	/**
	 * @param payment - a payment to add
	 * @return - this builder for chaining
	 * @throws NullPointerException - if payment is null
	 */
	private Builder interests(Payment payment) throws NullPointerException {
	    return this;
	}

	/**
	 * @param interests
	 * @return - this builder for chaining
	 */
	private Builder interests(double interests) {
	    return this;
	}

	/**
	 * @param total
	 * @return - this builder for chaining
	 */
	private Builder total(double total) {
	    return this;
	}
    }

    /**
     * Returns the total interests for this schedule.
     *
     * @return - the total interests
     */
    public double getInterests() {
	return interests;
    }

    /**
     * Returns an unmodifiable view of the payments.
     *
     * @return - the total interests
     */
    public List<Payment> getPayments() {
	return payments;
    }

    /**
     * Returns the total paid for this schedule.
     *
     * @return - the total interests
     */
    public double getTotal() {
	return total;
    }

    @Override
    /**
     * Returns a complete string representation of this schedule. Please note that
     * the backed List of payments toString method is not chained; instead this
     * implementation prints the size of the list.
     *
     * @return - the total paid
     */
    public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
    }
}
