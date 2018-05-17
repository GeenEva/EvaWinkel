package eva.dummy.domain;

public class EvaAddress {
	
	private int addressId;
	private String street;
	private String zipcode;
	private String city;
	private int personId;
	public String getStreet() {
		return street;
		
	}
	
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	
	public int getAddressId() {
		return addressId;
	}
	
	public void setStreet(String street) {
		this.street = street;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getPersonId() {
		return personId;
	}
	public void setPersonId(int personId) {
		this.personId = personId;
	}
	
	@Override
	public String toString() {
		
		return this.getStreet() + " " + this.getZipcode() + " " + this.getCity();
	}
	
}
