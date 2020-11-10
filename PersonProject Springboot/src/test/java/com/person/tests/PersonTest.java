package com.person.tests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.junit.Assert.*;

import java.util.List;

import com.person.controller.PersonResource;
import com.person.model.Person;
import com.person.service.PersonService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PersonResource.class)
@WithMockUser
public class PersonTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PersonService personService;
	
	
	@Test
	public void savePersonTest() throws Exception{
		Person mockPerson = new Person(1,"Mock Person","1234567890","1234567890123");
		
		Mockito.when(personService.savePerson(Mockito.any(Person.class))).thenReturn(mockPerson);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/person")
										.accept(MediaType.APPLICATION_JSON)
										.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		
	}
	
	@Test
	public void getPeopleTest() throws Exception {
		List<Person> mockPeopleList = (List<Person>) new Person(1,"Mock Person","1234567890","1234567890123");
		Mockito.when(personService.getPeople()).thenReturn(mockPeopleList);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/people").accept(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		System.out.println(result.getResponse());
		String expected = "{id:1,fullName:Vuyisa,phoneNumber:1234567890,idNumber:1234567890123}";
		
		JSONAssert.assertEquals(expected, result.getResponse()
				.getContentAsString(), false);
	}
	
}
