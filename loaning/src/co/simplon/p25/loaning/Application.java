package co.simplon.p25.loaning;

import co.simplon.p25.loaning.ui.Cli;

public final class Application {

	private static String props;

	public static void main(String[] args) {
		
		try {
				props = args[0];
				Cli instance = Cli.getInstance();
				instance.start(props);
				instance.start(props);
				instance.stop();
			} catch (ArrayIndexOutOfBoundsException e) {
				System.err.println("Properties file path is missing !");
			}
//		InputStream input = null;
		
		
		
//		try {
//			input = new FileInputStream(args[0]);
//		} catch (FileNotFoundException e1) {
//			// TODO Auto-generated catch block
//			System.out.println(e1.getMessage());
//		}
//
//            
//            try {
//            	
//            	prop = new Properties();
//				prop.load(input);
//					
//			} catch (ArrayIndexOutOfBoundsException e1) {
//				// TODO Auto-generated catch block
//				e1.getMessage();
//			}
//            
//            
//            
//        
//            // get the property value and print it out
//            System.out.println(prop.getProperty("cli.welcome"));

	}

}
