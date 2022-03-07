/**
 *
 */
package co.simplon.p25.loaning.ui;

import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import co.simplon.p25.loaning.calculator.Payment;
import co.simplon.p25.loaning.calculator.Request;
import co.simplon.p25.loaning.calculator.Schedule;
import co.simplon.p25.loaning.calculator.ScheduleMethod;

/**
 * An utility class with static methods to help reading and writing from/to the
 * CLI. Provides a method to convert and validate a scanned input line into a
 * CliInputs instance, and a method to print the Schedule.
 *
 */
final class CliUtil {

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
    static CliInputs toCliInputs(String inputLine) throws CliInputsException {
	try {
	    Matcher matcher = splitUserInput(inputLine);
	    matcher.find();
	    double amount = validateAmount(matcher.group(1));
	    int duration = validateDuration(matcher.group(2));
	    double rate = validateRate(matcher.group(3));
	    Request request = new Request.Builder(amount, duration, rate).build();
	    ScheduleMethod method = ScheduleMethod.valueOf​(matcher.group(4));
	    return new CliInputs.Builder(method, request).build();
	} catch (Exception e) {
	    throw new CliInputsException();
	}
    }

    /**
     * Split the user input from the regular expression representing the expected
     * pattern
     *
     * @param userInput
     * @return A new matcher for the expected pattern
     */
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
    private static double validateAmount(String userAmount) throws CliInputsException {
	double convertUserInput = Double.valueOf(userAmount);
	if (convertUserInput < 100 || convertUserInput > 1000000) {
	    throw new CliInputsException();
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
    private static int validateDuration(String userDuration) throws CliInputsException {
	int convertUserInput = Integer.valueOf(userDuration);
	if (convertUserInput < 1 || convertUserInput > 30) {
	    throw new CliInputsException();
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
    private static double validateRate(String userRate) throws CliInputsException {
	double convertUserInput = Double.valueOf(userRate);
	if (convertUserInput < 0.05 || convertUserInput > 20) {
	    throw new CliInputsException();
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
    static void printSchedule​(Properties properties, Schedule schedule) throws NullPointerException {
	if (properties == null) {
	    throw new NullPointerException("Properties are not defined !");
	} else if (schedule == null) {
	    throw new NullPointerException("schedule can not be null !");
	}

	printScheduleHeader(properties);

	// Print each schedule formatted payment on the Cli
	for (int period = 0; period < schedule.getPayments().size(); period++) {
	    Payment payment = schedule.getPayments().get(period);
	    String formatPayment = String.format("%-10d%,-20.2f%,-20.2f%,-20.2f%,.2f", period + 1,
		    payment.getPrincipal(), payment.getInterests(), payment.getTotal(), payment.getRemaining());
	    System.out.println(formatPayment);
	}

	printScheduleFooter(schedule);
    }

    /**
     * Print the schedule header on the CLI
     *
     * @param properties - Application properties
     */
    static private void printScheduleHeader(Properties properties) {
	String period = properties.getProperty("cli.period.period");
	String principal = properties.getProperty("cli.period.principal");
	String interest = properties.getProperty("cli.period.interest");
	String total = properties.getProperty("cli.period.total");
	String remaining = properties.getProperty("cli.period.remaining");

	String header = String.format("%-10s%-20s%-20s%-20s%s", period, principal, interest, total, remaining);
	System.out.println(header);
    }

    /**
     * Print the schedule footer on the CLI
     *
     * @param schedule - The schedule to print
     */
    static private void printScheduleFooter(Schedule schedule) {
	String footer = String.format("%-10s%-20s%,-20.2f%,-20.2f", " ", " ", schedule.getInterests(),
		schedule.getTotal());
	System.out.println(footer);
    }

}
