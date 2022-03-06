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

    /**
     * @param builder
     */
    public Payment(Builder builder) {
	principal = builder.principal;
	interests = builder.interests;
	total = builder.total;
	remaining = builder.remaining;
    }

    static final class Builder {
	private double principal;
	private double interests;
	private double total;
	private double remaining;

	Builder() {
	}

	/**
	 * @param principal
	 * @return - this builder for chaining
	 */
	Payment.Builder principal(double principal) {
	    this.principal = principal;
	    return this;
	}

	/**
	 * @param interests
	 * @return - this builder for chaining
	 */
	Payment.Builder interests(double interests) {
	    this.interests = interests;
	    return this;
	}

	/**
	 * @param total
	 * @return - this builder for chaining
	 */
	Payment.Builder total(double total) {
	    this.total = total;
	    return this;
	}

	/**
	 * @param remaining
	 * @return - this builder for chaining
	 */
	Payment.Builder remaining(double remaining) {
	    this.remaining = remaining;
	    return this;
	}

	/**
	 * Builds a new Payment.
	 *
	 * @return - a new payment instance
	 */
	Payment build() {
	    return new Payment(this);
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
	return String.format("%,.2f%,15.2f%,15.2f%,15.2f", principal, interests, total, remaining);
    }
}
