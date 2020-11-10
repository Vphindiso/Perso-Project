package com.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.model.Person;
import com.person.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	public Person savePerson(Person person) {
		return repository.save(person);
	}
	
	public List<Person> getPeople(){
		List<Person> people = (List<Person>) repository.findAll();
		return people;
	} 
}
