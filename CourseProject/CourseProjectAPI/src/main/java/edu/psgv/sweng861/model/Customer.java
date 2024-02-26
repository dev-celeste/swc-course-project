package edu.psgv.sweng861.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

/** This class is a model for the Customers table and represents one customer.
 * @author Maria Alcantara
*/
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

	//---------------------------fields
	/** Represents the customer’s unique ID.
	*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator="CUSTOMER_ID_GEN")
	@SequenceGenerator(name = "CUSTOMER_ID_GEN", sequenceName = "CUSTOMER_ID_SEQ")
	private int id;
	/** Represents the customer's first name.
	*/
	@NotBlank(message = "First name must not be blank")
	private String firstName;
	/** Represents the customer's last name.
	*/
	@NotBlank(message = "Last name must not be blank")
	private String lastName;
	/** Represents the customer's address.
	*/
	private String address;
	/** Represents the customer's city of residence.
	*/
	private String city;
	/** Represents the customer's state of residence.
	*/
	private String state;
	/** Represents the customer's zip code of residence.
	*/
	private int zipcode;
	/** Represents the customer's email address.
	*/
	@NotBlank(message = "First name must not be blank")
	private String email;
	/** Represents the customer's phone number.
	*/
	private String phoneNumber;
	
	//--------------------------------constructors
	/** Creates a customer without any specified details.
	*/
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/** Creates a customer with the specified details but without an ID (good for auto generated ID situations).
	 * @param firstName is the customer's first name.
	 * @param lastName is the customer's last name.
	 * @param address is the customer's street address including street number and street name.
	 * @param city is the customer's city of residence.
	 * @param state is the customer's state of residence.
	 * @param zipcode is the customer's zip code of residence.
	 * @param email is the customer's email address.
	 * @param phone number is the customer's phone number.
	*/
	public Customer(@NotBlank(message = "First name must not be blank") String firstName,
			@NotBlank(message = "Last name must not be blank") String lastName, String address, String city,
			String state, int zipcode, @NotBlank(message = "First name must not be blank") String email,
			String phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	/** Creates a customer with all specified fields.
	 * @param id is the customer's unique ID.
	 * @param firstName is the customer's first name.
	 * @param lastName is the customer's last name.
	 * @param address is the customer's street address including street number and street name.
	 * @param city is the customer's city of residence.
	 * @param state is the customer's state of residence.
	 * @param zipcode is the customer's zip code of residence.
	 * @param email is the customer's email address.
	 * @param phone number is the customer's phone number.
	*/
	public Customer(int id, @NotBlank(message = "First name must not be blank") String firstName,
			@NotBlank(message = "Last name must not be blank") String lastName, String address, String city,
			String state, int zipcode, @NotBlank(message = "First name must not be blank") String email,
			String phoneNumber) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.email = email;
		this.phoneNumber = phoneNumber;
	}
	
	//---------------------------------------getters and setters
	/** Gets the customer’s ID.
	 * @return An int representing the retrieved customer’s ID.
	*/
	public int getId() {
		return id;
	}
	/** Sets the customer’s ID.
	 * @param id is an int that will be used to set the ID field.
	*/
	public void setId(int id) {
		this.id = id;
	}
	/** Gets the customer’s first name.
	 * @return A string representing the retrieved customer’s first name.
	*/
	public String getFirstName() {
		return firstName;
	}
	/** Sets the customer’s first name.
	 * @param firstName is a String that will be used to set the firstName field.
	*/
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/** Gets the customer’s last name.
	 * @return A string representing the retrieved customer’s last name.
	*/
	public String getLastName() {
		return lastName;
	}
	/** Sets the customer’s last name.
	 * @param lastName is a String that will be used to set the lastName field.
	*/
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/** Gets the customer’s ID.
	 * @return An int representing the retrieved customer’s ID.
	*/
	public String getAddress() {
		return address;
	}
	/** Sets the customer’s address.
	 * @param address is a String that will be used to set the address field.
	*/
	public void setAddress(String address) {
		this.address = address;
	}
	/** Gets the customer’s city of residence.
	 * @return A String representing the retrieved customer’s city.
	*/
	public String getCity() {
		return city;
	}
	/** Sets the customer’s city.
	 * @param city is a String that will be used to set the city field.
	*/
	public void setCity(String city) {
		this.city = city;
	}
	/** Gets the customer’s state of residence.
	 * @return A String representing the retrieved customer’s state.
	*/
	public String getState() {
		return state;
	}
	/** Sets the customer’s state.
	 * @param state is a String that will be used to set the state field.
	*/
	public void setState(String state) {
		this.state = state;
	}
	/** Gets the customer’s zipcode.
	 * @return An int representing the retrieved customer’s zipcode.
	*/
	public int getZipcode() {
		return zipcode;
	}
	/** Sets the customer’s zipcode.
	 * @param zipcode is an int that will be used to set the zipcode field.
	*/
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	/** Gets the customer’s email address.
	 * @return A String representing the retrieved customer’s email.
	*/
	public String getEmail() {
		return email;
	}
	/** Sets the customer’s email.
	 * @param email is a String that will be used to set the email field.
	*/
	public void setEmail(String email) {
		this.email = email;
	}
	/** Gets the customer’s phone number.
	 * @return A String representing the retrieved customer’s phone number.
	*/
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/** Sets the customer’s phone number.
	 * @param phoneNumber is a String that will be used to set the phoneNumber field.
	*/
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	//---------------------------------------hashcode, equals, and to string
	
	@Override
	public int hashCode() {
		return Objects.hash(address, city, email, firstName, id, lastName, phoneNumber, state, zipcode);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(address, other.address) && Objects.equals(city, other.city)
				&& Objects.equals(email, other.email) && Objects.equals(firstName, other.firstName) && id == other.id
				&& Objects.equals(lastName, other.lastName) && Objects.equals(phoneNumber, other.phoneNumber)
				&& Objects.equals(state, other.state) && zipcode == other.zipcode;
	}
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", address=" + address
				+ ", city=" + city + ", state=" + state + ", zipcode=" + zipcode + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
	
	
	
	
	
	
}
