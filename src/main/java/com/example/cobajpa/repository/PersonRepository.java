package com.example.cobajpa.repository;



import org.springframework.data.repository.CrudRepository;

import com.example.cobajpa.model.Person;

public interface PersonRepository extends CrudRepository<Person, Long> {
//	List<Person> findByName(String name);
//	List<Person> findPersonDistinctByName(String name);
//	List<Person> findPersonOrderByNameDesc();
}
