package de.gothaer.personenservice.services;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import de.gothaer.personenservice.repositories.PersonenRepository;

@ExtendWith(MockitoExtension.class)
public class PersonenServiceImplTest {
	
	@InjectMocks private PersonenServiceImpl objectUnderTest;
	@Mock private PersonenRepository repoMock;
	
}
