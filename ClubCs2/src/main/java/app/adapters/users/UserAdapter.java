package app.adapters.users;

import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.adapters.users.repository.UserRepository;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.UserPort;

public class UserAdapter implements UserPort {
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
		PersonEntity personEntity = personEntityAdapter(person);
		UserEntity userEntity = userRepository.findByPersonId(personEntity);
		User user = userAdapter(userEntity);
		return user;
	}

	private User userAdapter(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User user = new User();
		user.setPersonId(userEntity.getPerson().getPersonId());
		user.setDocument(userEntity.getPerson().getDocument());
		user.setName(userEntity.getPerson().getName());
		user.setCellPhone(userEntity.getPerson().getCellPhone());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setRole(userEntity.getRole());
		user.setUserId(userEntity.getUserId());
		return user;
		
	}

	private UserEntity userEntityAdapter(User user) {
		PersonEntity personEntity = personEntityAdapter(user);
		UserEntity userEntity = new UserEntity();
		userEntity.setPerson(personEntity);
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setRole(user.getRole());
		return userEntity;
	}

	private PersonEntity personEntityAdapter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(user.getPersonId());
		personEntity.setDocument(user.getDocument());
		personEntity.setName(user.getName());
		personEntity.setCellPhone(user.getCellPhone());
		return personEntity;
	}

}
