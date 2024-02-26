package edu.psgv.sweng861.service;

import java.util.List;

import edu.psgv.sweng861.model.Customer;

/** This class is a service interface for Customer, in charge of dictating how the service implementation should behave.
 * @author Maria Alcantara
*/
public interface CustomerService {
	//----------------------------------READ
	/** gathers all customers in our database and stores them in a list.
	 * @return A list of all customers stored in our database.
	*/
	public List<Customer> getCustomers();
	/** searches for a customer with a matching customer ID.
	 * @param id is an int passed in from the controller and then passed along to the repository layer.
	 * @return A customer found through its ID.
	*/
	public Customer getCustomerById(int id);
	/** searches for customers with matching last names.
	 * @param lastName is a String passed in from the controller and then passed along to the repository layer.
	 * @return A list of customers found through their shared last name.
	*/
	public List<Customer> getCustomersByLastName(String lastName);
	/** searches for a customer with a matching phone number.
	 * @param phoneNumber is a String passed in from the controller and then passed along to the repository layer.
	 * @return A customer found through their unique phone number.
	*/
	public Customer getCustomerByPhoneNumber(String phoneNumber);
	
	//----------------------------------CREATE
	/** adds a customer to our database.
	 * @param customer is our object passed in from the controller and then passed along to the repository layer.
	 * @return a customer object matching the one that was just created.
	*/
	public Customer createCustomer(Customer customer);
	
	//----------------------------------UPDATE
	/** updates an existing customer in our database.
	 * @param customer is our object passed in from the view and then passed along to the repository layer.
	 * @return a customer object matching the one that was just updated.
	*/
	public Customer updateCustomer(Customer customer);
	//----------------------------------DELETE
	/** deletes the designated customer from our database.
	 * @param id is our customer's ID passed in from the controller and then passed along to the repository layer.
	*/
	public void removeCustomer(int id);
}
