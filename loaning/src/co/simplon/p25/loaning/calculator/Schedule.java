/**
 *
 */
package co.simplon.p25.loaning.calculator;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an amortization schedule. Provides a builder in order to help
 * constructing immutable instances.
 */
public final class Schedule {

    private List<Payment> payments = new ArrayList<Payment>();
    private double interests;
    private double total;

    /**
     * @param builder
     */
    public Schedule(Builder builder) {
	payments = builder.payments;
	interests = builder.interests;
	total = builder.total;
    }

    /**
     * A builder to build Schedule instances.
     */
    static final class Builder {
	private List<Payment> payments = new ArrayList<Payment>();
	private double interests;
	private double total;

	Builder() {
	}

	/**
	 * Builds a new Schedule with specified payments, interests and total.
	 *
	 * @return a new Schedule instance
	 */
	Schedule build() {
	    return new Schedule(this);
	}

	/**
	 * @param payment - a payment to add
	 * @return - this builder for chaining
	 * @throws NullPointerException - if payment is null
	 */
	Builder add(Payment payment) throws NullPointerException {
	    this.payments.add(payment);
	    return this;
	}

	/**
	 * @param interests
	 * @return - this builder for chaining
	 */
	Builder interests(double interests) {
	    this.interests += interests;
	    return this;
	}

	/**
	 * @param total
	 * @return - this builder for chaining
	 */
	Builder total(double total) {
	    this.total += total;
	    return this;
	}
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
     * Returns the total interests for this schedule.
     *
     * @return - the total interests
     */

    public double getInterests() {
	return interests;
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
