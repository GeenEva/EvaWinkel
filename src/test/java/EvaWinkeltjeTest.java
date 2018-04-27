import eva.dummy.dao.*;
import eva.dummy.domain.*;
import eva.dummy.domain.Person.*;

public class EvaWinkeltjeTest {
	public static void main(String[] args) {
		
		Person persontje = new Person.PersonBuilder().
				setPersonType(TypeOfPerson.BOSS).setName("Lotje").setLastName("Lepel").build();
		
	
		System.out.println(persontje.toString());
		
		PersonDAO personDAO = new PersonDAOImp();
		
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
		
		
		
		Person persontje4 = personDAO.createDatabasePerson(persontje3);
		
	System.out.println(persontje4.toString());
	}
}
