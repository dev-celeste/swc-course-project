package edu.psgv.sweng861.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.psgv.sweng861.model.Customer;

/** This class is a repository interface for Customer, in charge of dictating how the repository implementation should behave.
 * @author Maria Alcantara
*/
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	/** checks if a customer with the specified ID exists.
	 * @param id is an int passed in from the view to the service to the repository layer.
	 * @return A boolean that confirms if the customer exists.
	*/
	boolean existsById(int id);
	/** searches for customers with specified last name and returns them in a list.
	 * @param lastName is a String passed in from the view to the service to the repository layer.
	 * @return A list of customers that share a last name.
	*/
	List<Customer> findByLastName(String lastName);
	/** searches for one customer with the specified phone number.
	 * @param phoneNumber is a String passed in from the view to the service to the repository layer.
	 * @return A customer that has that unique phone number.
	*/
	Customer findByPhoneNumber(String phoneNumber);
}
