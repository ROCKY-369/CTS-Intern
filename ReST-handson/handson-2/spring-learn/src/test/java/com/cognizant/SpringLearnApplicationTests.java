package com.cognizant;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


import com.cognizant.controller.CountryController;
import com.jayway.jsonpath.JsonPath;

@SpringBootTest
@AutoConfigureMockMvc
class SpringLearnApplicationTests {
	
	@Autowired
	private CountryController controller;
	
	@Autowired
	private MockMvc mvc;
	
	@Test
	void contextLoads() {
		assertNotNull(controller);
	}
	
	@Test
	public void testGetCountry() throws Exception{
		ResultActions actions=this.mvc.perform(get("/country"));
		actions.andExpect(status().isOk());
		actions.andExpect(jsonPath("$.code").exists());
		actions.andExpect(jsonPath("$.code").value("IN"));
		actions.andExpect(jsonPath("$.name").exists());
		actions.andExpect(jsonPath("$.name").value("India"));
	}
	
	@Test
	public void testGetCountryException() throws Exception {
		ResultActions actions=this.mvc.perform(get("/country/az"));
		actions.andExpect(status().isNotFound());
		actions.andExpect(status().reason("country not found"));
	}

}
