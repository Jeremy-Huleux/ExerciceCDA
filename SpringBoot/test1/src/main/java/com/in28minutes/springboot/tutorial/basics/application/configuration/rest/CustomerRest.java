package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.CustomerService;



@RestController
@RequestMapping("/customers")
public class CustomerRest {

  @Autowired
  private CustomerService customerService;

  @GetMapping("/allCustomers")
  public List<Customer> getAllCustomers() {
      return customerService.getCustomers();
  }
  
  @PostMapping("/add")
  public void addEmploye(@RequestBody Customer customer){
    customerService.addCustomer(customer);
  }
    
  @PutMapping("/update")
  public void updateCustomer(@RequestBody Customer customer) {
    customerService.updateCustomer(customer);
  }

  @DeleteMapping("/delete")
  public void deleteCustomer(@RequestBody Customer customer) {
    customerService.deleteCustomer(customer);
  }
}
