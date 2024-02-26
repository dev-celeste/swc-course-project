package edu.psgv.sweng861.controller;

import java.net.URI;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.psgv.sweng861.model.Customer;
import edu.psgv.sweng861.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

	public static Logger Logger = LogManager.getLogger();
	
	/** This brings the service layer into play with our controller.
	*/
	private CustomerService customerService;

	/** Creates a customer controller injected with the service object.
	 * @param customerService is the service object.
	*/
	public CustomerController(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	//-----------------------------READ
	/** displays a list of all customers stored in our database.
	 * @return A list of all customers.
	*/
	@Operation(summary = "Allows us to grab all customers stored")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
	})
	@GetMapping
	public List<Customer> getCustomers() {
		return customerService.getCustomers();
	}
	
	/** searches and displays one customer from our database which has the specific ID.
	 * @param id is used to search for a customer with that ID.
	 * @return one customer with that ID.
	*/
	@Operation(summary = "Grabs one customer by id number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/{id}")
	public Customer getCustomerById(@PathVariable int id) {
		return customerService.getCustomerById(id);
	}
	
	/** searches and displays a list of customers from our database, all of which have the same last name.
	 * @param lastName is used to search for customers.
	 * @return A list of customers with common last names.
	*/
	@Operation(summary = "Grabs list of customerss with common last name")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/customername/{lastName}")
	public List<Customer> getCustomerByLastName(@PathVariable String lastName) {
		return customerService.getCustomersByLastName(lastName);
	}
	
	/** searches and displays one customer from our database which has the specific phone number.
	 * @param phoneNumber is used to search for a customer with that phone number.
	 * @return one customer with that phone number.
	*/
	@Operation(summary = "Grabs one customer by phone number")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE)),
			@ApiResponse(responseCode = "404")
	})
	@GetMapping("/customernumber/{phoneNumber}")
	public Customer getCustomerByPhoneNumber(@PathVariable String phoneNumber) {
		return customerService.getCustomerByPhoneNumber(phoneNumber);
	}
	
	//-----------------------------CREATE
	/** creates a customer in our database.
	 * @param @Valid @RequestBody customer is our customer object being passed in from our form with validation.
	 * @return A response entity that lets the UI know if the customer was successfully created.
	*/
	@PostMapping
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer customer) {
		Customer createdCustomer = customerService.createCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(createdCustomer.getId()).toUri();
		return ResponseEntity.created(location).body(createdCustomer);
	}
	
	//-----------------------------UPDATE
	/** updates a customer in our database.
	 * @param @RequestBody customer is our customer object being passed in from our form with validation.
	 * @return A response entity that lets the UI know if the customer was successfully updated.
	*/
	@PutMapping("/updatecustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer = customerService.updateCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(updatedCustomer.getId()).toUri();
		return ResponseEntity.created(location).body(updatedCustomer);
	}
	//-----------------------------DELETE
	/** deletes a customer from our database.
	 * @param customer is our customer object being passed in from our form.
	 * @return A response entity that lets the UI know if the customer was successfully deleted.
	*/
	@DeleteMapping("/deletecustomer/{id}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("id") int id) {
		customerService.removeCustomer(id);
		return ResponseEntity.noContent().build();
	}
}
