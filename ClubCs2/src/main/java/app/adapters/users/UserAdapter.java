package app.adapters.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.adapters.users.repository.UserRepository;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
@NoArgsConstructor
@Service
public class UserAdapter implements UserPort {
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean existUserName(String userName) {
		return userRepository.existsByUserName(userName);
	}

	@Override
	public void saveUser(User user) {
		UserEntity userEntity = userEntityAdapter(user);
		userRepository.save(userEntity);
		user.setUserId(userEntity.getUserId());
	}

	@Override
	public User findByPersonId(Person person) {
		PersonEntity personEntity = personAdapter(person);
		UserEntity userEntity = userRepository.findByPersonId(personEntity);
		User user = userAdapter(userEntity);
		return user;
	}
	
	@Override
	public User findByUserName(User user) {
		UserEntity userEntity = userRepository.findByUserName(user.getUserName());
		if (userEntity == null){
			return null;
		}
		return userAdapter(userEntity);
	}


	private User userAdapter(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User user = new User();
		user.setPersonId(userEntity.getPersonId().getPersonId());
		user.setDocument(userEntity.getPersonId().getDocument());
		user.setName(userEntity.getPersonId().getName());
		user.setCellPhone(userEntity.getPersonId().getCellPhone());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setRole(userEntity.getRole());
		user.setUserId(userEntity.getUserId());
		return user;
		
	}

	private UserEntity userEntityAdapter(User user) {
		PersonEntity personEntity = personAdapter(user);
		UserEntity userEntity = new UserEntity();
		userEntity.setPersonId(personEntity);
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setRole(user.getRole());
		return userEntity;
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
