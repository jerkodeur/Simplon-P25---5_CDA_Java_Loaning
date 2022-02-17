package co.simplon.p25.loaning.ui;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Scanner;

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
     * Starts the CLI. Blocks until the conversation finishes.
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
	    throw new CliException("Error when loading the properties file");
	}

	System.out.println(props.getProperty("cli.welcome"));
	getUserInput();
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
	System.out.println("The instance is now Closed !");
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
    private String getUserInput() {
	System.out.println(props.getProperty("cli.request"));
	return scanner.nextLine();
    }

}
