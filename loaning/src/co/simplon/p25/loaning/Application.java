package co.simplon.p25.loaning;

import java.util.Locale;

import co.simplon.p25.loaning.ui.Cli;
import co.simplon.p25.loaning.ui.CliException;

/**
 * The Loaning application class defining the main method.
 */
public final class Application {

    /**
     * Starts and stops the CLI.
     * <p>
     * Catches CliExceptions printing an error message and the cause.
     * <p>
     * Expects the CLI properties file path as first argument of the main method
     * arguments.
     *
     * @param args - the application arguments
     * @throws ArrayIndexOutOfBoundsException if no arguments is present
     */
    public static void main(String[] args) {
	// Set default locale for the hole application
	Locale.setDefault(Locale.ENGLISH);

	try {
	    Cli instance = Cli.getInstance();
	    if (args.length == 0) {
		throw new ArrayIndexOutOfBoundsException("Properties file path is missing !");
	    }
	    instance.start(args[0]);

	    instance.stop();
	} catch (CliException e) {
	    System.err.println(e.getMessage());
	    if (e.getCause() != null) {
		System.err.println(e.getCause());
	    }
	}
    }

}
