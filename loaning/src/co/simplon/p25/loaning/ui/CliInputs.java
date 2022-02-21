/**
 *
 */
package co.simplon.p25.loaning.ui;

import co.simplon.p25.loaning.calculator.Request;
import co.simplon.p25.loaning.calculator.ScheduleMethod;

/**
 * Represents the user converted and validated schedule request inputs from the
 * CLI. Provides a builder in order to help constructing immutable instances.
 *
 */
public final class CliInputs {

    private Request request;
    private ScheduleMethod method;

    private CliInputs(Builder builder) {
	this.request = builder.request;
	this.method = builder.method;
    }

    /**
     * Builds a new CliInputs
     */
    public static final class Builder {
	private final Request request;
	private final ScheduleMethod method;

	/**
	 * Initialize the builder
	 *
	 * @param request
	 * @param method
	 */
	public Builder(ScheduleMethod method, Request request) {
	    this.request = request;
	    this.method = method;
	    method(method);
	    request(request);
	}

	/**
	 * Builds a new CliInputs with specified request and method.
	 *
	 * @return - a new CliInputs instance
	 */
	public CliInputs build() {
	    return new CliInputs(this);
	}

	/**
	 * Set the given method.
	 *
	 * @param method - a method
	 * @return this builder for chaining
	 * @throws NullPointerException - if method is null
	 */
	private Builder method(ScheduleMethod method) throws NullPointerException {
	    if (method == null) {
		throw new NullPointerException("Error, The method is not defined !");
	    }

	    return this;
	}

	/**
	 * Set the given request.
	 *
	 * @param request - a request
	 * @return this builder for chaining
	 * @throws NullPointerException - if payment is null
	 */
	private Builder request(Request request) throws NullPointerException {
	    if (request == null) {
		throw new NullPointerException("Error, The request is not defined !");
	    }
	    return this;
	}
    }

    /**
     * Returns the calculation method.
     *
     * @return the calculation method; nerver null
     */
    public ScheduleMethod getMethod() {
	return method;
    }

    /**
     * Returns the request.
     *
     * @return the request; nerver null
     */
    public Request getRequest() {
	return request;
    }

    @Override
    /**
     * Returns a complete string representation of this CLI inputs.
     *
     * @return string representation of this CLI inputs
     */
    public String toString() {
	return super.toString();
    }

}
