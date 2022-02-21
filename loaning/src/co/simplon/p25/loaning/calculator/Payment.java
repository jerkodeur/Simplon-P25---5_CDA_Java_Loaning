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
	    this.principal = principal;
	    this.interests = interests;
	    this.total = total;
	    this.remaining = remaining;

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
	public Builder principal(double principal) {
	    return this;
	}

	/**
	 * @param interests
	 * @return - this builder for chaining
	 */
	public Builder interests(double interests) {
	    return this;
	}

	/**
	 * @param total
	 * @return - this builder for chaining
	 */
	public Builder total(double total) {
	    return this;
	}

	/**
	 * @param remaining
	 * @return - this builder for chaining
	 */
	public Builder remaining(double remaining) {
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
	// TODO Auto-generated method stub
	return super.toString();
    }
}
