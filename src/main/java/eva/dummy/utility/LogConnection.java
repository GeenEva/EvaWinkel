package eva.dummy.utility;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;


public class LogConnection {
	private final static Logger logger = Logger.getLogger(LogConnection.class.getName());

	public LogConnection() {
	}

	public static void initLogger() {

		LogManager.getLogManager().reset();
		logger.setLevel(Level.ALL);
		
		FileHandler fh = null;
		SimpleFormatter sf = new SimpleFormatter();
		
		try {

			fh = new FileHandler("log.xml", true); // Remove true to get a new xmlFile on every run. true means append
													// to the previous logs
			fh.setLevel(Level.ALL);
			fh.setFormatter(sf);
			/* fh.setFormatter(xmlFormatter); */
			// logger.addHandler(ch);
			logger.addHandler(fh);
		} catch (SecurityException ex) {
			logger.log(Level.WARNING, "Security error ocured", ex.getMessage());

		} catch (IOException e) {
			logger.log(Level.SEVERE, "IO exception occured, check log.xml", e.getMessage());

		}

	}
	public static Logger getLogger() {

		initLogger();
		return logger;
	}
}
