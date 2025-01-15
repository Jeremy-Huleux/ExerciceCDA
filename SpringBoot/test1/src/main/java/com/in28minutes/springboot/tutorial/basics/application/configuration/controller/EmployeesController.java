package com.in28minutes.springboot.tutorial.basics.application.configuration.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Employee;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.EmployeeService;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;



@Controller
public class EmployeesController {
    
    @Autowired
	private EmployeeService employeeService;


    @InitBinder
	public void initBinder(WebDataBinder binder) {
		// Date - dd/MM/yyyy
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}

    @RequestMapping("/employees")
    public ModelAndView employeesList() {
        List<Employee> listEmployees=employeeService.getEmployees();
        /*for(Employee e:listEmployees) {
            System.out.println(e.getLastName());
        }*/
        ModelAndView mav = new ModelAndView("employees");
        mav.addObject("employees", listEmployees);
        return mav; 
    }

    @RequestMapping("/employees/add")
    public String showAddEmployeePage(ModelMap model) {
        model.addAttribute("employee", new Employee());
		model.addAttribute("title", "Ajouter Employé");
        return "addemployee";
    }

    @RequestMapping(value = "/employees/add", method = RequestMethod.POST)
	public String addEmployee(ModelMap model, Employee employee, BindingResult result) {

		if (result.hasErrors()) {
            
			return "addemployee";
		}

		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}
    
    @RequestMapping(value = "/employees/update", method = RequestMethod.GET)
	public String showUpdateEmployeePage(@RequestParam long id, ModelMap model) {
		Employee employee = employeeService.getEmployeeById(id).get();
		model.put("employee", employee);
        model.addAttribute("title", "Mettre à jour Employé");
		return "addemployee";
	}

    @RequestMapping(value = "/employees/update", method = RequestMethod.POST)
	public String updateEmployee(ModelMap model, Employee employee, BindingResult result) {

		if (result.hasErrors()) {
			return "addemployee";
		}

		employeeService.updateEmployee(employee);
		return "redirect:/employees";
	}

    @RequestMapping(value = "/employees/delete", method = RequestMethod.GET)
	public String deleteEmployee(@RequestParam long id) {
		employeeService.deleteEmployee(id);
		
		return "redirect:/employees";
	}
}
