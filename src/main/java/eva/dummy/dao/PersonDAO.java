package eva.dummy.dao;

import java.util.List;

import eva.dummy.domain.Person;

public interface PersonDAO {
	public Person getDatabasePerson(Person person);
	public Person createDatabasePerson(Person person);
	public Person updateDatabasePerson(Person person);
	public void deleteDatabasePerson(Person person);
	
}
