package com.in28minutes.springboot.tutorial.basics.application.configuration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService{

  @Autowired
  private CustomerRepository customerRepository;


  @Override
  public List<Customer> getCustomers() {
    return customerRepository.findAll();
  }

  @Override
  public Optional<Customer> getCustomerById(Long id) {
    return customerRepository.findById(id);
  }

  @Override
  public void updateCustomer(Customer customer) {
    customerRepository.save(customer);
  }

  @Override
  // public boolean addCustomer(Long customerId, String lastName, String firstName, String company, String address,
  // String city, String state, String country, String postalCode, String phone, String fax, String email,
  // Long supportRepId) {
  public void addCustomer(Customer customer){
    
    // try {
    //   customerRepository.save(new Customer(
    //     customerId, 
    //     lastName, 
    //     firstName, 
    //     company, 
    //     address,
    //     city, 
    //     state, 
    //     country, 
    //     postalCode, 
    //     phone, 
    //     fax, 
    //     email, 
    //     supportRepId));
    //     rep = true;
    
      customerRepository.save(customer);
    
    // catch (DataAccessException e) {
    //     System.err.println("Erreur d'accès aux données : " + e.getMessage());
    //     throw e;
    // }

    
  }

  

  @Override
  public void deleteCustomer(Customer customer) {
    customerRepository.delete(customer);
  }

  @Override
  public void saveCustomer(Customer customer) {
    customerRepository.save(customer);
  }


}
