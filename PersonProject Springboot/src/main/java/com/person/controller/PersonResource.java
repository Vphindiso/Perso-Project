package com.person.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.model.Person;
import com.person.service.PersonService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class PersonResource {

	@Autowired
	private PersonService personService ;
	
	@PostMapping("/person")
	public Person savePerson(@RequestBody Person person) {
		return personService.savePerson(person);
	}
	
	@RequestMapping("/people")
	public List<Person> getPeople(){
		return personService.getPeople();
	}
}
