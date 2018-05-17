package eva.dummy.dao;

import eva.dummy.domain.EvaAddress;
import eva.dummy.domain.EvaPerson;

public interface AddressDAO {
	public EvaAddress getDatabaseAddress(EvaPerson peron);
	public EvaAddress createDatabaseAddress(EvaAddress address, EvaPerson person);
	public EvaAddress updateDatabaseAddress(EvaAddress address);
	public EvaAddress deleteDatabaseAddress(EvaAddress address);
}
