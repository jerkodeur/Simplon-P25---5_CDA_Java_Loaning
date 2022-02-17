package co.simplon.p25.loaning;

import co.simplon.p25.loaning.ui.Cli;
import co.simplon.p25.loaning.ui.CliException;

public final class Application {

    public static void main(String[] args) {

	try {
	    Cli instance = Cli.getInstance();
	    instance.start(args[0]);
	} catch (ArrayIndexOutOfBoundsException e) {
	    System.err.println("Properties file path is missing !");
	} catch (CliException e) {
	    System.err.println(e.getMessage());
	}

    }

}
