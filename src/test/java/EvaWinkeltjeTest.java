import eva.dummy.dao.*;
import eva.dummy.domain.*;
import eva.dummy.domain.EvaPerson.*;

public class EvaWinkeltjeTest {
	public static void main(String[] args) {
		/*
		
		PersonDAO personDAO = new PersonDAOImp();
		
		EvaPerson persontje = new EvaPerson.PersonBuilder().
				setPersonType(TypeOfPerson.BOSS).setName("Juanita").setLastName("Klomp").build();
		
	
		System.out.println(persontje.toString());
		
		
		
		EvaPerson persontje2 = personDAO.createDatabasePerson(persontje);
		
	System.out.println(persontje2.toString());
		
		EvaAddress addressJe = new EvaAddress();
		addressJe.setStreet("KadaKade");
		addressJe.setZipcode("1342ZP");
		addressJe.setCity("Zwijndrecht");
		
		AddressDAO addressDAO = new AddressDAOImp();
		
		EvaAddress addressJe2 = addressDAO.createDatabaseAddress(addressJe, persontje2);
		
		System.out.println(persontje2.toString() + " " + addressJe2.toString());
		
		*/
		/*
		EvaPerson persontje3 = new EvaPerson.PersonBuilder().
				setPersonType(TypeOfPerson.SLAVE).setName("Piet").setLastName("de Vork").build();
		
		PersonDAO personDAO = new PersonDAOImp();
		
		EvaPerson persontje3 = new EvaPerson.PersonBuilder().setPersonId(13).build();
		
	System.out.println(persontje3.toString());	
	
		EvaPerson persontje4 = personDAO.getDatabasePerson(persontje3);
		
		
		
	System.out.println(persontje4.toString());
	*/
		
	//	/*
		
		// Update persoon kan alleen met 'compleet' persoon
		PersonDAO personDAO = new PersonDAOImp();
		EvaPerson person5 = new EvaPerson.PersonBuilder().setPersonId(14).
				setPersonType(TypeOfPerson.CLOWN).setName("Roy").setLastName("Joy").
			build();
	
		personDAO.updateDatabasePerson(person5);
		
	//	*/
		/*
		PersonDAO personDAO = new PersonDAOImp();
		EvaPerson person6 = new EvaPerson.PersonBuilder().setPersonId(11).build();
		
		personDAO.deleteDatabasePerson(person6);
		*/
	}
}
