package de.gothaer.personenservice.services;

import de.gothaer.personenservice.models.Person;
import de.gothaer.personenservice.repositories.PersonenRepository;

public class PersonenServiceImpl {
	
	private final PersonenRepository repo;

	public PersonenServiceImpl(PersonenRepository repo) {
		this.repo = repo;
	}
	
	
	/*
	 *  person null -> PSE
	 *  vorname darf nicht null sein und muss min 2 Zeichen -> PSE
	 *  nachname darf nicht null sein und muss min 2 Zeichen -> PSE
	 *  
	 *  Attila -> PSE
	 *  
	 *  wandele RuntimeException aus Repo in PSE
	 *  
	 *  Person im Repo speichern
	 */
	public void speichern(Person person) throws PersonenServiceException {
		
	}

}
