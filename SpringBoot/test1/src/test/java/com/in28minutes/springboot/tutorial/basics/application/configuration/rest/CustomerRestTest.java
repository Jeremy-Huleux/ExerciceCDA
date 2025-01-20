package com.in28minutes.springboot.tutorial.basics.application.configuration.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.in28minutes.springboot.tutorial.basics.application.configuration.model.Customer;
import com.in28minutes.springboot.tutorial.basics.application.configuration.service.impl.CustomerService;

@WebMvcTest(CustomerRest.class)
public class CustomerRestTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService customerService;

	@Test
	public void deleteCustomer
	() throws Exception {
		Customer customer = new Customer(123L, "abc", "abc", "abc", "abc", "abc", "abc", "abc", "abc", "abc", "abc", "abc", 123L);
		ObjectMapper objectMapper = new ObjectMapper();
		String json = objectMapper.writeValueAsString(customer);
		this.mockMvc.perform(put("/customers/delete").content(json).contentType(MediaType.APPLICATION_JSON_VALUE))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE));
	}
}
