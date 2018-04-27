package eva.dummy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import eva.dummy.domain.*;
import eva.dummy.utility.DatabaseConnectionClass;
import eva.dummy.utility.LogConnection;


public class AddressDAOImp implements AddressDAO{

	private Logger logger = LogConnection.getLogger();
	
	
	public Address getDatabaseAddress(Person person) {
		
		String query = "SELECT * FROM address WHERE person_id = ?";
		Address address1 = new Address();
	
		try (
				Connection connection = DatabaseConnectionClass.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query,
						PreparedStatement.RETURN_GENERATED_KEYS); ) 
			{

			preparedStatement.setInt(1, person.getPersonId());
			
			preparedStatement.executeUpdate();
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys();) {

					address1.setAddressId(resultSet.getInt(1));
					address1.setStreet(resultSet.getString(2));
					address1.setZipcode(resultSet.getString(3));
					address1.setCity(resultSet.getString(4));
					address1.setPersonId(resultSet.getInt(5));
				
			}
			logger.log(Level.INFO, "Addres succesfully returned");
			return address1;

		} catch (SQLException e) {
			logger.log(Level.WARNING, "SQL exception occured", e);

		}

		return null;
	}
	

	public Address createDatabaseAddress(Address address, Person person) {
		
		String query = "INSERT INTO address (street, zipcode, city, person_id) VALUES (?,?,?,?)";
		
		try (
			Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query,
					PreparedStatement.RETURN_GENERATED_KEYS);) {
		
			preparedStatement.setString(1, address.getStreet());
			preparedStatement.setString(2, address.getZipcode());
			preparedStatement.setString(3,  address.getCity());
			preparedStatement.setInt(4, person.getPersonId());
			
			preparedStatement.executeUpdate();
			
			System.out.println("Person succesfully created");
			logger.log(Level.INFO, "Person succesfully created");
			
			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {
				
				address.setAddressId(resultSet.getInt(1));
				address.setStreet(resultSet.getString(2));
				address.setZipcode(resultSet.getString(3));
				address.setCity(resultSet.getString(4));
				address.setPersonId(resultSet.getInt(5));
				
			} 
		} catch (SQLException e) {
			logger.log(Level.WARNING, "SQL Exception occured while trying to make an address", e);
		}
		return address;
	}
	
	

	public Address updateDatabaseAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	public Address deleteDatabaseAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

}
