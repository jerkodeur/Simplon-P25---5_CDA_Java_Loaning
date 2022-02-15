package co.simplon.p25.loaning;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Application {

	public static void main(String[] args) throws ArrayIndexOutOfBoundsException, FileNotFoundException, IOException {
		InputStream input = new FileInputStream(args[0]);

        Properties prop = new Properties();

        // load a properties file
        prop.load(input);

        // get the property value and print it out
        System.out.println(prop.getProperty("cli.welcome"));

	}

}
