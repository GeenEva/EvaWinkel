package eva.dummy.utility;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;


public class DatabaseConnectionClass {
	
	private static Logger logger = LogConnection.getLogger();
	
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	public static void initializeXML() {
		File xmlFile = new File("src/main/java/eva/dummy/utility/SQLDBConnection.xml");
		
		if(xmlFile.exists()) {
			
			try {

				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
				Document document = dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
				URL = document.getElementsByTagName("url").item(0).getTextContent();
				USER = document.getElementsByTagName("user").item(0).getTextContent();
				PASSWORD = document.getElementsByTagName("password").item(0).getTextContent();
				logger.log(Level.CONFIG,"Xml file exist, parsing is succesfull.");
			} catch (ParserConfigurationException | SAXException | IOException e) {
				logger.log(Level.WARNING, "Parser/Sax/IOexception occured check log", e);

			}
		} else {
			logger.log(Level.INFO, "xmlFile is not existing.");
		}

	}

	public static Connection getConnection() throws SQLException {

		/*
		 * First perform a check. if one of this values is null call the initialize
		 * method otherwise skip it.
		 */
		if (URL == null | USER == null | PASSWORD == null) {
			
			initializeXML();
		}
		Connection conn = null;
		try {

			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			logger.log(Level.INFO, "Connected to Database");
			System.out.println("Connected to the Database.");

		} catch (SQLException e) {
			logger.log(Level.WARNING, "SQL exeception ocurred. Connection with database failed.", e);

		}

		return conn;
	}
}
