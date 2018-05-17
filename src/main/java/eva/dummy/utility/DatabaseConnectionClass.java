package eva.dummy.utility;

import java.io.File;
import java.io.IOException;
import java.net.UnknownHostException;
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

import com.mongodb.MongoClient;


public class DatabaseConnectionClass {
	
	private static Logger logger = LogConnection.getLogger();
	
	private static String URL;
	private static String USER;
	private static String PASSWORD;
	
	
	//Method for parsing through xml file and setting the data fields
	public static void initializeSQLXML() {
		
		File xmlFile = new File("src/main/java/eva/dummy/utility/SQLDBConnection.xml");
		
		if(xmlFile.exists()) {
			
			try {

				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
				//parse through the xml file
				Document document = dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
		
				//set the variables for the connection
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
	
	public static void initializeMongoXML() {
		
		File xmlFile = new File("src/main/java/eva/dummy/utility/MongoDBConnection.xml");
		
		if (xmlFile.exists()) {
			
			try {
				DocumentBuilder dBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			
				//parse through the xml file
				Document document = dBuilder.parse(xmlFile);
				document.getDocumentElement().normalize();
	
				//set the variables for the connection
				URL = document.getElementsByTagName("url").item(0).getTextContent();
				USER = document.getElementsByTagName("user").item(0).getTextContent();
					
				logger.log(Level.CONFIG,"Xml file exist, parsing is succesfull.");
				
			} catch (ParserConfigurationException | SAXException | IOException e) {
				logger.log(Level.WARNING, "Parser/Sax/IOexception occured check log", e);
			}
		} else {
			logger.log(Level.INFO, "xmlFile is not existing.");
		
		}
	}

	//Getting connection (object) with MySQL database
	public static Connection getSQLConnection() throws SQLException {

		if (URL == null | USER == null | PASSWORD == null) {
			
			initializeSQLXML();
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
	
	//Getting connection (object) with Mongo database
	public static void getMongoConnection()  {
		
		if (URL == null | USER == null) {
			initializeMongoXML();
		}
			
		Connection conn = null;
		try {
			MongoClient mongoClient = new MongoClient("localhost" , 27017 );
			
			
		} catch (Exception ex) {
			logger.log(Level.WARNING, "Mongo exeception ocurred. Connection with database failed.", ex);
		}
		
		
	}
}
