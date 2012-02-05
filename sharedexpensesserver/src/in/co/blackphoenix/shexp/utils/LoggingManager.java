package in.co.blackphoenix.shexp.utils;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggingManager {

	private static Logger myLogger = null;
	
	private LoggingManager(){}
	
	public static Logger getMyLogger(){
		
		if(myLogger == null){
			
			myLogger = Logger.getLogger("SHEXP Logger");
			
			FileHandler fh;
			try {
				
				fh = new FileHandler(System.getProperty("user.dir") + "\\" + "SHEXPLogger.log", true);
				myLogger.addHandler(fh);
				myLogger.setLevel(Level.ALL);
				SimpleFormatter formatter = new SimpleFormatter();
				fh.setFormatter(formatter);
			
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (IOException ie) {
				// TODO Auto-generated catch block
				ie.printStackTrace();
			}
		}
		
		return myLogger;
	}
}
