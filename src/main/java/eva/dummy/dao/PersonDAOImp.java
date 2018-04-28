package eva.dummy.dao;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.lang.Enum;


import eva.dummy.domain.*;
import eva.dummy.domain.Person;
import eva.dummy.domain.Person.TypeOfPerson;
import eva.dummy.utility.DatabaseConnectionClass;
import eva.dummy.utility.LogConnection;

public class PersonDAOImp implements PersonDAO {
	private Logger logger = LogConnection.getLogger();


	public Person getDatabasePerson(Person person) {

		Person person1 = new Person.PersonBuilder().build(); 
		String query = "SELECT * FROM person WHERE person_id = ?";

		try(Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query); ) {

			preparedStatement.setInt(1, person.getPersonId());

			try (ResultSet resultSet = preparedStatement.executeQuery();) {
				
				Person.PersonBuilder buildert = new Person.PersonBuilder();
				
				if (resultSet.next()) {
				buildert.setPersonId(resultSet.getInt(1));
				buildert.setPersonType(TypeOfPerson.valueOf(resultSet.getString(2)));
				buildert.setName(resultSet.getString(3));
				buildert.setLastName(resultSet.getString(4));
				
				person1 = buildert.build();
				}
			}		

			logger.log(Level.INFO, "Person succesfully returned");
			return person1;

		} catch (SQLException e) {
			logger.log(Level.WARNING, "SQL exception occured", e);
		}
		return null;
	}



	public Person createDatabasePerson(Person person) {
		
		String tempForEnum = "" + (person.getPersonType());
		
		int generatedId = 0;
		String query = "INSERT INTO person (person_type, name, last_name) VALUES (?,?,?)";

		try (Connection connection = DatabaseConnectionClass.getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(query,
						PreparedStatement.RETURN_GENERATED_KEYS);) 	{
			
			preparedStatement.setString(1, tempForEnum);
			preparedStatement.setString(2, person.getName());
			preparedStatement.setString(3, person.getLastName());
			
			preparedStatement.executeUpdate();

			System.out.println("Person succesfully created");
			logger.log(Level.INFO, "Person succesfully created");

			try (ResultSet resultSet = preparedStatement.getGeneratedKeys()) {

				if (resultSet.next()) {

					generatedId = resultSet.getInt(1);
					logger.log(Level.INFO, "Key succesfully generated");
					
					Person.PersonBuilder buildert = new Person.PersonBuilder().setPersonId(generatedId).
							setPersonType(person.getPersonType()).setName(person.getName()).setLastName(person.getLastName());
					
					person = buildert.build();
				}
			}

		} catch (SQLException e) {
			logger.log(Level.WARNING, "Person was not created", e);
		}

		return person;
	}


	public Person updateDatabasePerson(Person person) {
		
		String tempEnum = "" + person.getPersonType();
		String query = "UPDATE person SET person_type = ?, name = ?, last_name = ?"
				+ "WHERE person_id = ?";
		
		try(Connection connection = DatabaseConnectionClass.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(query);) {
			
				preparedStatement.setString(1, tempEnum);
				preparedStatement.setString(2, person.getName());
				preparedStatement.setString(3,  person.getLastName());
				preparedStatement.setInt(4, person.getPersonId());
				
				preparedStatement.executeUpdate();
				logger.log(Level.INFO, "Person successfully updated");
				
				
		} catch(SQLException e) {
			logger.log(Level.WARNING, "Person couldn't been updated", e);
		}
		return null;
	}

	public Person deleteDatabasePerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

}
