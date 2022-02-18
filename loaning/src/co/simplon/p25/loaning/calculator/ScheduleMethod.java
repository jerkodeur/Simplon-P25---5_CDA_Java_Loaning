package co.simplon.p25.loaning.calculator;

/**
 * The enumeration of Schedule calculation methods providing a fabric method.
 *
 */
public enum ScheduleMethod {

    @SuppressWarnings("javadoc")
    STRAIGHT_LINE {
	@Override
	public StraightLineCalculator calculator(Request request) {
	    return new StraightLineCalculator();
	}
    },

    @SuppressWarnings("javadoc")
    ANNUITY {
	@Override
	public AnnuityCalculator calculator(Request request) {
	    return new AnnuityCalculator(null);
	}
    };

    /**
     * Fabric method returning an instance of the calculator for this calculation
     * method.
     *
     * @param request - the schedule request
     * @return the calculator instance for this calculation method
     */
    public abstract Calculator calculator(Request request);

    /**
     * Returns the enum constant of this type with the specified name. The string
     * must match exactly an identifier used to declare an enum constant in this
     * type. (Extraneous whitespace characters are not permitted.)
     *
     * @param name - the name of the enum constant to be returned.
     * @return the enum constant with the specified name
     * @throws IllegalArgumentException - if this enum type has no constant with the
     *                                  specified name
     * @throws NullPointerException     - if the argument is null
     */
    public static ScheduleMethod valueOf​(String name) throws IllegalArgumentException, NullPointerException {
	ScheduleMethod method = ScheduleMethod.valueOf(name);
	System.out.println(method);

	if (name == null) {
	    System.out.println("test");
	    throw new NullPointerException("No schedule method provided!");
	} else if (method == null) {
	    throw new IllegalArgumentException("The argument schedule method provided is not valid!");
	}

	return method;
    }
}
