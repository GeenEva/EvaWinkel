package eva.dummy.domain;


public class EvaPerson {
	
	//Enum type
	public enum TypeOfPerson{BOSS, SLAVE, CLOWN};
	
	//Data fields for EvaPerson
	private int personId;
	private TypeOfPerson personType;
	private String name;
	private String lastName;
	
	//Constructor for EvaPerson with a builder object as a parameter
	//setting the EvaPerson fields as the value given by builder
	
	private EvaPerson(PersonBuilder builder) {
		
		this.personId = builder.personId;
		this.personType = builder.personType;
		this.name = builder.name;
		this.lastName = builder.lastName;
		
	}
	
		//A Builder class with data fields
		public static class PersonBuilder{
		
			private int personId;
			private TypeOfPerson personType;
			private String name;
			private String lastName;
		
	
			//Default constructor for PersonBuilder
			public PersonBuilder() {
			}
	
			
			//Constructor with EvaPerson class as parameter
			public PersonBuilder(EvaPerson person) {
		
				this.personId = person.personId;
				this.personType = person.personType;
				this.name = person.name;
				this.lastName = person.lastName;
			}
	
			
			//Methods that set the field values and give a PersonBuilder object back
			public PersonBuilder setPersonId(int personId) {
				this.personId = personId;
				return this;
			}
		
			public PersonBuilder setPersonType(TypeOfPerson personType) {
				this.personType = personType;
				return this;
			}
		
			public PersonBuilder setName(String name) {
				this.name = name;
				return this;
			}
			
			public PersonBuilder setLastName(String lastName) {
				this.lastName = lastName;
				return this;
			}
			
			//Build method that gives a EvaPerson back
			
			public EvaPerson build() {
				return new EvaPerson(this);
			}
		}
		
		//Builder class ends here
	
		
	//Getters for EvaPerson
	
	
	public int getPersonId() {
		return personId;
	}
	
	public TypeOfPerson getPersonType() {
		return personType;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	
	@Override
	public String toString() {
		
		return "EvaPerson id = " + this.getPersonId() + ", EvaPerson type = " + this.getPersonType() +
				", Name = " + this.getName() + ", Last name = " + this.getLastName() + " ";
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EvaPerson other = (EvaPerson) obj;
		if (personId != other.personId)
			return false;
		return true;
	}
	
}
