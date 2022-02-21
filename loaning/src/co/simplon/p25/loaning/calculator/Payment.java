/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * Represents a periodic payment. Provides a builder in order to help
 * constructing immutable instances.
 */
public final class Payment {
    private double principal;
    private double interests;
    private double total;
    private double remaining;

    private Payment(Builder builder) {
	this.principal = builder.principal;
	this.interests = builder.interests;
	this.total = builder.total;
	this.remaining = builder.remaining;
    }

    static final class Builder {
	private double principal;
	private double interests;
	private double total;
	private double remaining;

	public Builder(double principal, double interests, double total, double remaining) {
	    principal(principal);
	    interests(interests);
	    total(total);
	    remaining(remaining);
	    build();
	}

	/**
	 * Builds a new Payment.
	 *
	 * @return - a new payment instance
	 */
	private Payment build() {
	    return new Payment(this);
	}

	/**
	 * @param principal
	 * @return - this builder for chaining
	 */
	private Builder principal(double principal) {

	    this.principal = principal;
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

	/**
	 * @param remaining
	 * @return - this builder for chaining
	 */
	private Builder remaining(double remaining) {
	    return this;
	}

    }

    /**
     * @return principal
     */
    public double getPrincipal() {
	return principal;
    }

    /**
     * @return interests
     */
    public double getInterests() {
	return interests;
    }

    /**
     * @return total
     */
    public double getTotal() {
	return total;
    }

    /**
     * @return remaining
     */
    public double getRemaining() {
	return remaining;
    }

    @Override
    /**
     * Returns a complete string representation of this payment.
     *
     * @return a string representation of this payment
     */
    public String toString() {
	String formattedPayment = String.format("%.2f%8.2f%8.2f%8.2f", principal, interests, total, remaining);
	return formattedPayment;
    }
}
