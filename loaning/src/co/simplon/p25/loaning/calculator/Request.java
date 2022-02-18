/**
 *
 */
package co.simplon.p25.loaning.calculator;

/**
 * Represents a schedule request. Provides a builder in order to help
 * constructing immutable instances.
 */
public final class Request {

    /**
     * A builder to build Request instances.
     */
    public static final class Builder {
	private double amount;
	private int duration;
	private double rate;

	/**
	 * Builds a new Request with specified request and method.
	 *
	 * @return - a new Request instance
	 */
	public Request build() {
	    return new Request();
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
