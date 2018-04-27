import eva.dummy.dao.*;
import eva.dummy.domain.*;
import eva.dummy.domain.Person.*;

public class EvaWinkeltjeTest {
	public static void main(String[] args) {
		/*
		Person persontje = new Person.PersonBuilder().
				setPersonType(TypeOfPerson.BOSS).setName("Lotje").setLastName("Lepel").build();
		
	
		System.out.println(persontje.toString());
		
		
		
		Person persontje2 = personDAO.createDatabasePerson(persontje);
		
	System.out.println(persontje2.toString());
		
		Address addressJe = new Address();
		addressJe.setStreet("Rijnstraat");
		addressJe.setZipcode("1234AZ");
		addressJe.setCity("Rotterdam");
		
		AddressDAO addressDAO = new AddressDAOImp();
		
		Address addressJe2 = addressDAO.createDatabaseAddress(addressJe, persontje2);
		
		System.out.println(persontje2.toString() + " " + addressJe2.toString());
		
		
		Person persontje3 = new Person.PersonBuilder().
				setPersonType(TypeOfPerson.SLAVE).setName("Piet").setLastName("de Vork").build();
		*/
		
		PersonDAO personDAO = new PersonDAOImp();
		
		Person persontje3 = new Person.PersonBuilder().setPersonId(12).build();
		
	System.out.println(persontje3.toString());	
	
		Person persontje4 = personDAO.getDatabasePerson(persontje3);
		
		
		
	System.out.println(persontje4.toString());
	
		Person person5 = new Person.PersonBuilder().setPersonId(persontje4.getPersonId()).
				setPersonType(persontje4.getPersonType()).
				setName(persontje4.getName()).setLastName("de Haan").build();
	
		personDAO.updateDatabasePerson(person5);
	
	}
}
