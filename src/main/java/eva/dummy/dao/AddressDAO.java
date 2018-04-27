package eva.dummy.dao;

import eva.dummy.domain.Address;
import eva.dummy.domain.Person;

public interface AddressDAO {
	public Address getDatabaseAddress(Person peron);
	public Address createDatabaseAddress(Address address, Person person);
	public Address updateDatabaseAddress(Address address);
	public Address deleteDatabaseAddress(Address address);
}
