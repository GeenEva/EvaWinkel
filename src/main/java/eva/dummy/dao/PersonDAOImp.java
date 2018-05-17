package eva.dummy.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import eva.dummy.domain.EvaPerson;
import eva.dummy.domain.EvaPerson.TypeOfPerson;
import eva.dummy.utility.DatabaseConnectionClass;
import eva.dummy.utility.LogConnection;


public class PersonDAOImp implements PersonDAO {
	private Logger logger = LogConnection.getLogger();


	public EvaPerson getDatabasePerson(EvaPerson person) {

		EvaPerson person1 = new EvaPerson.PersonBuilder().build(); 
		String query = "SELECT * FROM person WHERE person_id = ?";

		try(
			Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query); 
			) {

			preparedStatement.setInt(1, person.getPersonId());

			try (
				ResultSet resultSet = preparedStatement.executeQuery();
				) {
				
				EvaPerson.PersonBuilder buildert = new EvaPerson.PersonBuilder();
				
				if (resultSet.next()) {
				buildert.setPersonId(resultSet.getInt(1));
				buildert.setPersonType(TypeOfPerson.valueOf(resultSet.getString(2)));
				buildert.setName(resultSet.getString(3));
				buildert.setLastName(resultSet.getString(4));
				
				person1 = buildert.build();
				}
			}		

			logger.log(Level.INFO, "EvaPerson succesfully returned");
			
			return person1;

		} catch (SQLException e) {
			logger.log(Level.WARNING, "SQL exception occured", e);
		}
		return null;
	}



	public EvaPerson createDatabasePerson(EvaPerson person) {
		
		
		int generatedId = 0;
		String query = "INSERT INTO person (person_type, name, last_name) VALUES (?,?,?)";

		try (
			Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(
					query,PreparedStatement.RETURN_GENERATED_KEYS);
			) {
			
			preparedStatement.setString(1, String.valueOf(person.getPersonType()));
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getLastName());
			
			preparedStatement.executeUpdate();

			System.out.println("EvaPerson succesfully created");
			logger.log(Level.INFO, "EvaPerson succesfully created");

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

				if (resultSet.next()) {

					generatedId = resultSet.getInt(1);
					logger.log(Level.INFO, "Key succesfully generated");
					
					EvaPerson.PersonBuilder buildert = new EvaPerson.PersonBuilder().setPersonId(generatedId).
						setPersonType(person.getPersonType()).setName(person.getName()).setLastName(person.getLastName());
					
					person = buildert.build();
				}
			}

		} catch (SQLException e) {
			logger.log(Level.WARNING, "EvaPerson was not created", e);
		}

		return person;
	}


	public EvaPerson updateDatabasePerson(EvaPerson person) {
		
		//right now this method works only with all fields provided
		//for better result:
		//first get person from the database (by lastname? or id?)
		//create person object from result set
		//then update with UPDATE query as follows
		
		String query = "UPDATE person SET person_type = ?, name = ?, last_name = ?"
				+ "WHERE person_id = ?";
		
		try(
			Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
				) {
			
				preparedStatement.setString(1, String.valueOf(person.getPersonType()));
				preparedStatement.setString(2, person.getName());
				preparedStatement.setString(3,  person.getLastName());
				preparedStatement.setInt(4, person.getPersonId());
				
				preparedStatement.executeUpdate();
				logger.log(Level.INFO, "EvaPerson successfully updated");
				
				
		} catch(SQLException e) {
			logger.log(Level.WARNING, "EvaPerson couldn't been updated", e);
		}
		return null;
	}

	public void deleteDatabasePerson(EvaPerson person) {
		
		String query = "DELETE FROM person WHERE person_id = ?";
		
		try(
			Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);
				) {
			preparedStatement.setInt(1, person.getPersonId());
			preparedStatement.executeUpdate();
			
			logger.log(Level.INFO, "EvaPerson has been deleted");
			System.out.println("EvaPerson has been deleted from the database.");
			
		}
		catch(SQLException e) {
			logger.log(Level.WARNING, "EvaPerson not deleted because of SQL Exception", e);
		}
		
	}

}
