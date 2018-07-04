package com.example.cobajpa.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cobajpa.model.Person;
import com.example.cobajpa.repository.PersonRepository;

@Service
public class PersonServices {
	
	@Autowired
	PersonRepository personRepository;
	public List<Person> getAllPerson(){
		List<Person> lp=new ArrayList<>();
		personRepository.findAll().forEach(lp::add);
		return lp;
	}
	public Person getById(long id) {
		Person p=personRepository.findById(id).get();
		return p;
	}
	public void SaveOrUpdate(Person p) {
		personRepository.save(p);
	}
	public void deletePerson(long id) {
		personRepository.deleteById(id);
	}
	public void deletePerson(Person p) {
		personRepository.delete(p);
	}	
}
