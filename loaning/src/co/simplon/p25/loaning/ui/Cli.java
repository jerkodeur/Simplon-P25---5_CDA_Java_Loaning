package co.simplon.p25.loaning.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

import co.simplon.p25.loaning.calculator.Calculator;
import co.simplon.p25.loaning.calculator.Request;
import co.simplon.p25.loaning.calculator.Schedule;
import co.simplon.p25.loaning.calculator.ScheduleMethod;

/**
 * A Command Line Interface backed by a Scanner. Implemented as a Singleton.
 */
public final class Cli {
    private final Properties props = new Properties();
    private Scanner scanner;
    private static Cli INSTANCE;

    private Cli() {
    }

    /**
     * Returns the unique (singleton) instance of this Cli.
     *
     * @return The unique instance
     */
    public static Cli getInstance() {
	if (INSTANCE == null) {
	    INSTANCE = new Cli();
	}
	return INSTANCE;
    }

    /**
     * Starts the CLI. Blocks until the conversation finishes. Checks whether or not
     * the scanner is instantiated; if so, a CliException is thrown. Then loads the
     * CLI properties from the given path. Displays and waits for user interaction,
     * once the user inputs the schedule request line, delegates conversion and
     * validation to the CliUtil. In case of bad inputs, gives a retry to the user
     * with an error message. Once a schedule request is valid, uses the
     * ScheduleMethod fabrics to get a Calculator instance given the method
     * specified by the user. Then invokes the calulator to calculate the requested
     * schedule.
     *
     * Then delegates the printing of the schedule to the CliUtil class.
     *
     * Example 1 input: a=100000 d=1 r=1.2 m=ANNUITY
     *
     * Example 2 input: a=100000 d=1 r=1.2 m=STRAIGHT_LINE
     *
     * @param propertyPath - The path to the CLI properties file
     * @throws CliException - The CLI is already started; or the properties could
     *                      not be loaded from given properties path
     */
    public void start(String propertyPath) throws CliException {

	if (scanner != null) {
	    throw new CliException("The scanner is already open !");
	}

	scanner = new Scanner(System.in);

	try {
	    loadProperties(propertyPath);
	} catch (Exception e) {
	    throw new CliException("Error when loading the properties file", e);
	}

	System.out.println(props.getProperty("cli.welcome"));

	CliInputs cliInputs = getUserInputs();
	ScheduleMethod method = cliInputs.getMethod();
	Request request = cliInputs.getRequest();
	Calculator calculator = method.calculator(request);
	Schedule schedule = calculator.calculate();
	CliUtil.printSchedule​(props, schedule);

    }

    /**
     * Stops the CLI. Releases CLI all resources.
     *
     * @throws NullPointerException - The CLI was not started
     */
    public void stop() throws NullPointerException {
	if (scanner == null) {
	    throw new NullPointerException("The scanner is not running");
	}
	scanner.close();
	INSTANCE = null;
    }

    /**
     * Load the properties of the given file
     *
     * @param propertyPath
     * @throws IOException
     */
    private void loadProperties(String propertyPath) throws IOException {
	InputStream input = null;

	input = new FileInputStream(propertyPath);
	props.load(input);
    }

    /**
     * Request the user to enter needed schedule inputs
     *
     * @return User input
     */
    private CliInputs getUserInputs() {
	while (true) {
	    System.out.println(props.getProperty("cli.request"));
	    String userInput = scanner.nextLine();
	    try {
		return CliUtil.toCliInputs(userInput);
	    } catch (Exception e) {
		System.err.println(String.format("%s", props.getProperty("cli.request.error")));
	    }
	}
    }

}
