package edu.psgv.sweng861.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.psgv.sweng861.model.Customer;
import edu.psgv.sweng861.repository.CustomerRepository;

/** This class is a service for Account, in charge of passing valid requests from the view to the repository layer.
 * @author Maria Alcantara
*/
@Service
public class CustomerServiceImpl implements CustomerService {
	/** This brings the repository layer into play with our service.
	*/
	private CustomerRepository customerRepository;
	
	/** Creates a customer service implementation injected with the repository object.
	 * @param customerRepository is the repository object.
	*/
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	//----------------------------------READ
	/** gathers all customers in our database and stores them in a list.
	 * @return A list of all customers stored in our database.
	*/
	@Override
	public List<Customer> getCustomers() {
		return customerRepository.findAll();
	}
	/** searches for a customer with a matching customer ID.
	 * @param id is an int passed in from the controller and then passed along to the repository layer.
	 * @return A customer found through its ID.
	*/
	@Override
	public Customer getCustomerById(int id) {
		return customerRepository.findById(id).get();
	}
	/** searches for customers with matching last names.
	 * @param lastName is a String passed in from the controller and then passed along to the repository layer.
	 * @return A list of customers found through their shared last name.
	*/
	@Override
	public List<Customer> getCustomersByLastName(String lastName) {
		return customerRepository.findByLastName(lastName);
	}
	/** searches for a customer with a matching phone number.
	 * @param phoneNumber is a String passed in from the controller and then passed along to the repository layer.
	 * @return A customer found through their unique phone number.
	*/
	@Override
	public Customer getCustomerByPhoneNumber(String phoneNumber) {
		return customerRepository.findByPhoneNumber(phoneNumber);
	}

	//----------------------------------CREATE
	/** adds a customer to our database.
	 * @param customer is our object passed in from the controller and then passed along to the repository layer.
	 * @return a customer object matching the one that was just created.
	*/
	@Override
	public Customer createCustomer(Customer customer) {
		Customer returnedCustomer = new Customer();
		if (!customerRepository.existsById(customer.getId())) {
			returnedCustomer = customerRepository.save(customer);
		}
		return returnedCustomer;
	}

	//----------------------------------UPDATE
	/** updates an existing customer in our database.
	 * @param customer is our object passed in from the view and then passed along to the repository layer.
	 * @return a customer object matching the one that was just updated.
	*/
	@Override
	public Customer updateCustomer(Customer customer) {
		Customer returnedCustomer = new Customer();
		if (customerRepository.existsById(customer.getId())) {
			returnedCustomer = customerRepository.findById(customer.getId()).get();
			returnedCustomer.setFirstName(customer.getFirstName());
			returnedCustomer.setLastName(customer.getLastName());
			returnedCustomer.setAddress(customer.getAddress());
			returnedCustomer.setCity(customer.getCity());
			returnedCustomer.setState(customer.getState());
			returnedCustomer.setZipcode(customer.getZipcode());
			returnedCustomer.setEmail(customer.getEmail());
			returnedCustomer.setPhoneNumber(customer.getPhoneNumber());
			customerRepository.save(returnedCustomer);
		}
		return returnedCustomer;
	}

	//----------------------------------DELETE
	/** deletes the designated customer from our database.
	* @param id is our customer's ID passed in from the controller and then passed along to the repository layer.
	*/
	@Override
	public void removeCustomer(int id) {
		customerRepository.deleteById(id);

	}

}
