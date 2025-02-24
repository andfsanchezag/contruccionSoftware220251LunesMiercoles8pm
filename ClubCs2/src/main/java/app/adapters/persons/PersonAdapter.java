package app.adapters.persons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.persons.repository.PersonRepository;
import app.domain.models.Person;
import app.ports.PersonPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PersonAdapter implements PersonPort {
	@Autowired
	private PersonRepository personRepository;
	@Override
	public boolean existPerson(long document) {
		return personRepository.existsByDocument(document);
	}

	@Override
	public void savePerson(Person person) {
		PersonEntity personEntity = personAdapter(person);
		personRepository.save(personEntity);
		person.setPersonId(personEntity.getPersonId());
	}

	@Override
	public Person findByDocument(long document) {
		PersonEntity personEntity = personRepository.findByDocument(document);
		return personAdapter(personEntity);
	}

	private Person personAdapter(PersonEntity personEntity) {
		Person person= new Person();
		person.setPersonId(personEntity.getPersonId());
		person.setDocument(personEntity.getDocument());
		person.setName(personEntity.getName());
		person.setCellPhone(personEntity.getCellPhone());
                return person;
	}
	

	private PersonEntity personAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(person.getPersonId());
		personEntity.setDocument(person.getDocument());
		personEntity.setName(person.getName());
		personEntity.setCellPhone(person.getCellPhone());
		return personEntity;
	}
	
	

}
