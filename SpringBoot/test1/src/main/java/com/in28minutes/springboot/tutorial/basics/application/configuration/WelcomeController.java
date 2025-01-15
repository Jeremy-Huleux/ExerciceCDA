package com.in28minutes.springboot.tutorial.basics.application.configuration;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
import com.in28minutes.springboot.tutorial.basics.application.configuration.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class WelcomeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @RequestMapping("/")
    public ModelAndView homePage() {
        List<Employee> listEmployees = employeeRepository.findByOrderByLastNameAsc();
        listEmployees.forEach(employee -> {
            System.out.println(employee.toString());
        });
        //ModelAndView mav = new ModelAndView("employees");
        //mav.addObject("employees", listEmployees);
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("title", "Bienvenue de la médiathèque numérique");
        return mav; 
    }
}