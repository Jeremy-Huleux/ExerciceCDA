package com.in28minutes.springboot.tutorial.basics.application.configuration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    List<Customer> findByOrderByLastNameAsc();
}
