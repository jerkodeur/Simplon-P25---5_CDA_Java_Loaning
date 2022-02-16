package co.simplon.p25.loaning.ui;

import java.util.Scanner;

/**
 * A Command Line Interface backed by a Scanner. Implemented as a Singleton.
 * @author jerom
 * 
 */
public final class Cli {
	private Scanner scanner;
	private static Cli Instance;
	
	private Cli() {}
	
	/**
	 * Starts the CLI. Blocks until the conversation finishes.
	 * 
	 * @param PropertyPath The path to the CLI properties file
	 */
	public void start(String propertyPath) {	
		try {
			if(scanner != null) {
				throw new CliException("The cli is already open...");
			}
			System.out.println("Starts the CLI...");
			System.out.println("Enter your values");
			scanner = new Scanner(System.in);
			String userInput = scanner.nextLine();
			System.out.println(String.format("Your input: %s", userInput));
		} catch(CliException e) {
			System.err.println(e.getCause());
		}
	}
	
	/**
	 * Stops the CLI. Releases CLI all resources.
	 */
	public void stop() {
		Instance = null;
		System.out.println("The instance is now Closed !");
	}
	
	/**
	 * Returns the unique (singleton) instance of this Cli.
	 * @return The unique instance
	 */
	public static Cli getInstance() {
		if(Instance == null) {
			Instance = new Cli();
		}
		return Instance;
	}

}
