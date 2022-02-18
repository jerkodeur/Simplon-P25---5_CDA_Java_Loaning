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

    static final class Builder {

	/**
	 * Builds a new Payment.
	 *
	 * @return - a new payment instance
	 */
	private Payment build() {
	    return new Payment();
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
