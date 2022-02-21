package co.simplon.p25.loaning;

import co.simplon.p25.loaning.ui.Cli;

/**
 * The Loaning application class defining the main method.
 */
public final class Application {

    /**
     * Starts and stops the CLI. Catches CliExceptions printing an error message and
     * the cause. Expects the CLI properties file path as first argument of the main
     * method arguments; throws an ArrayIndexOutOfBoundsException if no argument is
     * present.
     *
     * @param args - the application arguments
     */
    public static void main(String[] args) {

	try {
	    Cli instance = Cli.getInstance();
	    if (args.length == 0) {
		throw new ArrayIndexOutOfBoundsException("Properties file path is missing !");
	    }
	    instance.start(args[0]);

	    instance.stop();
	} catch (Exception e) {
	    System.err.println(e.getMessage());
	    System.err.println(e.getCause());
	}
    }

}
