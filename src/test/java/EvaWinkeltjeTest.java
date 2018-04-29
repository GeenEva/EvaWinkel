import eva.dummy.dao.*;
import eva.dummy.domain.*;
import eva.dummy.domain.Person.*;

public class EvaWinkeltjeTest {
	public static void main(String[] args) {
		/*
		
		PersonDAO personDAO = new PersonDAOImp();
		
		Person persontje = new Person.PersonBuilder().
				setPersonType(TypeOfPerson.BOSS).setName("Juanita").setLastName("Klomp").build();
		
	
		System.out.println(persontje.toString());
		
		
		
		Person persontje2 = personDAO.createDatabasePerson(persontje);
		
	System.out.println(persontje2.toString());
		
		Address addressJe = new Address();
		addressJe.setStreet("KadaKade");
		addressJe.setZipcode("1342ZP");
		addressJe.setCity("Zwijndrecht");
		
		AddressDAO addressDAO = new AddressDAOImp();
		
		Address addressJe2 = addressDAO.createDatabaseAddress(addressJe, persontje2);
		
		System.out.println(persontje2.toString() + " " + addressJe2.toString());
		
		*/
		/*
		Person persontje3 = new Person.PersonBuilder().
				setPersonType(TypeOfPerson.SLAVE).setName("Piet").setLastName("de Vork").build();
		
		PersonDAO personDAO = new PersonDAOImp();
		
		Person persontje3 = new Person.PersonBuilder().setPersonId(13).build();
		
	System.out.println(persontje3.toString());	
	
		Person persontje4 = personDAO.getDatabasePerson(persontje3);
		
		
		
	System.out.println(persontje4.toString());
	*/
		
	//	/*
		
		// Update persoon kan alleen met 'compleet' persoon
		PersonDAO personDAO = new PersonDAOImp();
		Person person5 = new Person.PersonBuilder().setPersonId(14).
				setPersonType(TypeOfPerson.CLOWN).setName("Roy").setLastName("Joy").
			build();
	
		personDAO.updateDatabasePerson(person5);
		
	//	*/
		/*
		PersonDAO personDAO = new PersonDAOImp();
		Person person6 = new Person.PersonBuilder().setPersonId(11).build();
		
		personDAO.deleteDatabasePerson(person6);
		*/
	}
}
