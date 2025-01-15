package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.List;
import java.util.Optional;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;

public interface ICustomerService {

	List<Customer> getCustomers();

	Optional<Customer> getCustomerById(Long id);

	void updateCustomer(Customer customer);

	// boolean addCustomer( Long customerId, 
  //                   String lastName, 
  //                   String firstName, 
  //                   String company, 
  //                   String address, 
  //                   String city, 
  //                   String state, 
  //                   String country, 
  //                   String postalCode, 
  //                   String phone, 
  //                   String fax, 
  //                   String email, 
  //                   Long supportRepId
  //                   );

  void addCustomer(Customer customer);

	void deleteCustomer(Customer customer);
	
	void saveCustomer(Customer customer);

}
