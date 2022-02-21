/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * Represents a schedule request. Provides a builder in order to help
 * constructing immutable instances.
 */
public final class Request {
    private double amount;
    private int duration;
    private double rate;

    /**
     * Initialize the Request class
     *
     * @param builder
     */
    public Request(Builder builder) {
	amount = builder.amount;
	duration = builder.duration;
	rate = builder.rate;
    }

    /**
     * Returns the requested loan amount.
     *
     * @return the loan amount
     */
    public double getAmount() {
	return amount;
    }

    /**
     * Returns the requested loan duration in years.
     *
     * @return the loan duration
     */
    public int getDuration() {
	return duration;
    }

    /**
     * Returns the requested loan fixed annual rate.
     *
     * @return the loan rate
     */
    public double getRate() {
	return rate;
    }

    @Override
    /**
     * Returns a complete string representation of this request.
     *
     * @return a string representation of this request
     */
    public String toString() {
	return super.toString();
    }

    /**
     * A builder to build Request instances.
     */
    public static final class Builder {
	private final double amount;
	private final int duration;
	private final double rate;

	/**
	 * @param amount
	 * @param duration
	 * @param rate
	 */
	public Builder(double amount, int duration, double rate) {
	    this.amount = amount;
	    this.duration = duration;
	    this.rate = rate;
	}

	/**
	 * Builds a new Request with specified request and method.
	 *
	 * @return - a new Request instance
	 */
	public Request build() {
	    return new Request(this);
	}

	/**
	 * @param amount
	 * @return - this builder for chaining
	 */
	public Builder amount(double amount) {
	    return this;
	}

	/**
	 * @param duration
	 * @return - this builder for chaining
	 */
	public Builder duration(int duration) {
	    return this;
	}

	/**
	 * @param rate
	 * @return - this builder for chaining
	 */
	public Builder rate(double rate) {
	    return this;
	}
    }
}
