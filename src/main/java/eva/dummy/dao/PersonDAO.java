package eva.dummy.dao;

import java.util.List;

import eva.dummy.domain.EvaPerson;

public interface PersonDAO {
	public EvaPerson getDatabasePerson(EvaPerson person);
	public EvaPerson createDatabasePerson(EvaPerson person);
	public EvaPerson updateDatabasePerson(EvaPerson person);
	public void deleteDatabasePerson(EvaPerson person);
	
}
