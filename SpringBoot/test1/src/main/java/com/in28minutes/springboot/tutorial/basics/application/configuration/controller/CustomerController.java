// package com.in28minutes.springboot.tutorial.basics.application.configuration.controller;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.ModelMap;
// import org.springframework.validation.BindingResult;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.servlet.ModelAndView;

// import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;
// import com.in28minutes.springboot.tutorial.basics.application.configuration.service.CustomerService;

// @Controller
// public class CustomerController {

//   @Autowired
//   private CustomerService customerService;

//   @RequestMapping("/customers")
//   public ModelAndView customerList() {
//     List<Customer> listCustomers = customerService.getCustomers();
//     ModelAndView mav = new ModelAndView("customers");
//     mav.addObject("customers", listCustomers);
//     return mav;
//   }

//   @RequestMapping("/customers/add")
//   public String showAddEmployeePage(ModelMap model) {
//     model.addAttribute("customer", new Customer());
//     model.addAttribute("title", "Ajouter Customer");
//     return "addCustomer";
//   }

//   @RequestMapping(value = "/customers/add", method = RequestMethod.POST)
//   public String addEmployee(ModelMap model, Customer customer, BindingResult result) {

//     if (result.hasErrors()) {
//       return "addCustomer";
//     }

//     customerService.saveCustomer(customer);
//     return "redirect:/customers";
//   }

//   // @RequestMapping(value = "/employees/update", method = RequestMethod.GET)
//   // public String showUpdateEmployeePage(@RequestParam long id, ModelMap model) {
//   //   Employee employee = employeeService.getEmployeeById(id).get();
//   //   model.put("employee", employee);
//   //   model.addAttribute("title", "Mettre à jour Employé");
//   //   return "addemployee";
//   // }

//   // @RequestMapping(value = "/employees/update", method = RequestMethod.POST)
//   // public String updateEmployee(ModelMap model, Employee employee, BindingResult result) {

//   //   if (result.hasErrors()) {
//   //     return "addemployee";
//   //   }

//   //   employeeService.updateEmployee(employee);
//   //   return "redirect:/employees";
//   // }

//   // @RequestMapping(value = "/employees/delete", method = RequestMethod.GET)
//   // public String deleteEmployee(@RequestParam long id) {
//   //   employeeService.deleteEmployee(id);

//   //   return "redirect:/employees";
//   // }
// }
