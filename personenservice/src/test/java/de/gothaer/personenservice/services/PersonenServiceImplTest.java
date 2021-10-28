package de.gothaer.personenservice.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.gothaer.personenservice.models.Person;
import de.gothaer.personenservice.repositories.PersonenRepository;

@ExtendWith(MockitoExtension.class)
public class PersonenServiceImplTest {
	
	@InjectMocks private PersonenServiceImpl objectUnderTest;
	@Mock private PersonenRepository repoMock;
	
	@Test
	void speichern_parameterNull_throwsPersonenServiceException() throws Exception {
		PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(null));
		assertEquals("Person darf nicht null sein", ex.getMessage());
	}
	
	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"J","A"})
	void speichern_vornameZuKurzOderNull_throwsPersonenServiceException(String name) throws Exception {
		Person invalid = new Person(name, "Doe");
		PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(invalid));
		assertEquals("Vorname zu kurz", ex.getMessage());
	}

	@ParameterizedTest
	@NullAndEmptySource
	@ValueSource(strings = {"D","A"})
	void speichern_nachnameZuKurzOderNull_throwsPersonenServiceException(String name) throws Exception {
		
		Person invalid = new Person("John", name);
		PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(invalid));
		assertEquals("Nachname zu kurz", ex.getMessage());
	}

	@Test
	void speichern_Antipath_throwsPersonenServiceException() throws Exception {
		Person invalid = new Person("Attila", "Doe");
		PersonenServiceException ex = assertThrows(PersonenServiceException.class, ()->objectUnderTest.speichern(invalid));
		assertEquals("Antipath", ex.getMessage());
	}

	
}
