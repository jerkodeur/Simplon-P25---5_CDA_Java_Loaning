/**
 *
 */
package co.simplon.p25.loaning.ui;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.simplon.p25.loaning.calculator.Request;
import co.simplon.p25.loaning.calculator.Schedule;
import co.simplon.p25.loaning.calculator.ScheduleMethod;

/**
 * An utility class with static methods to help reading and writing from/to the
 * CLI. Provides a method to convert and validate a scanned input line into a
 * CliInputs instance, and a method to print the Schedule.
 *
 */
public final class CliUtil {
    private CliInputs userInputs;

    /**
     * @param userInput
     * @throws CliException
     */
    public CliUtil(String userInput) throws CliException {
	userInputs = toCliInputs(userInput);
    }

    /**
     * Converts and validates the schedule request inputs. The request inputs are
     * expected to be specified within a single input line. The input line must
     * match the expected pattern: - Example input: a=10000 d=1 r=1.15 m=ANNUITY -
     * a: the amount entered as an integer value. Must be between 100 and 1000000
     * inclusive - d: the duration entered as a decimal value. Must be between 1 and
     * 30 inclusive - r: the rate entered as a decimal value. Must be between 0.05
     * and 20.0 inclusive - m: the calculation method entered as a case-sensitive
     * string. Must be one of the available ScheduleMethods
     *
     * @param inputLine - the input line
     * @return a converted and validated CliInputs instance
     * @throws CliInputsException - if the given input line does not match the
     *                            expected pattern; or if any validation rule is
     *                            violated
     */
    private static CliInputs toCliInputs(String inputLine) throws CliException {

	Matcher matcher = splitUserInput(inputLine);

	try {
	    matcher.find();
	    double amount = validateAmount(matcher.group(1));
	    int duration = validateDuration(matcher.group(2));
	    double rate = validateRate(matcher.group(3));
	    Request request = new Request.Builder(amount, duration, rate).build();
	    ScheduleMethod method = ScheduleMethod.valueOf​(matcher.group(4));
	    return new CliInputs.Builder(method, request).build();
	} catch (CliException e) {
	    throw new CliException("Invalid input user");
	}
    }

    private static Matcher splitUserInput(String userInput) {
	String regexExpression = "a=(\\d{3,7})\\sd=(\\d{1,2})\\sr=([\\d]{1,2}|[\\d]{1,2}\\.[\\d]{1,2})\\sm=(ANNUITY|STRAIGHT_LINE)";

	Pattern pattern = Pattern.compile(regexExpression);
	return pattern.matcher(userInput);
    }

    /**
     * Validate the user amount input
     *
     * @param userAmount
     * @return convert user amount input
     * @throws CliException - Bad format for the amount
     */
    private static double validateAmount(String userAmount) throws CliException {
	double convertUserInput = Double.parseDouble(userAmount);
	if (convertUserInput < 100 || convertUserInput > 1000000) {
	    throw new CliException("Invalid input user");
	}
	return convertUserInput;
    }

    /**
     * Validate the user duration input
     *
     * @param userDuration
     * @return convert user duration input
     * @throws CliException - Bad format for the duration
     */
    private static int validateDuration(String userDuration) throws CliException {
	int convertUserInput = Integer.parseInt(userDuration);
	if (convertUserInput < 1 || convertUserInput > 30) {
	    throw new CliException("Invalid input user");
	}
	return convertUserInput;
    }

    /**
     * Validate the user rate input
     *
     * @param userRate
     * @return convert user rate input
     * @throws CliException - Bad format for the rate
     */
    private static double validateRate(String userRate) throws CliException {
	double convertUserInput = Double.parseDouble(userRate);
	if (convertUserInput < 0.05 || convertUserInput > 20) {
	    throw new CliException("Invalid input user");
	}
	return convertUserInput;
    }

    /**
     * Prints the given schedule with the help of specified CLI properties.
     *
     * Prints a header line with the labels provided by the properties file (period,
     * principal, interest, total and remaining). Then prints all the payment
     * periods, providing itself a period number from 1 to n. Finally prints the
     * footer with the total interests and total paid of the schedule.
     *
     * @param properties - the CLI properties
     * @param schedule   - the amortization schedule to print
     * @throws NullPointerException - if any of the argument is null
     */
    private static void printSchedule​(Properties properties, Schedule schedule) {
	// Print the amortization schedule
    }

    /**
     * Return the validate and convert user input
     *
     * @return a new CliInputs instance
     */
    public CliInputs getUserInputs() {
	return userInputs;
    }

}
