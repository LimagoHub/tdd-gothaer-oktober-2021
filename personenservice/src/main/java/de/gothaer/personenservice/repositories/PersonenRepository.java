package de.gothaer.personenservice.repositories;

import java.util.List;

import de.gothaer.personenservice.models.Person;

public interface PersonenRepository {
	
	void saveOrUpdate(Person p);
	void deleteById(String id);
	List<Person> findAll();

}
