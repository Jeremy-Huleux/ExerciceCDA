package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.EmployeeService;


@RestController
@RequestMapping("/employees")
public class EmployeeRest {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping("/allEmployees")
  public List<Employee> employeesList() {
    return employeeService.getEmployees();
  }

}
