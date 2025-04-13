package app.adapters.partners;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.partners.entity.PartnerEntity;
import app.adapters.partners.repository.PartnerRepository;
import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Partner;
import app.domain.models.User;
import app.ports.PartnerPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Service
public class PartnerAdapter implements PartnerPort {
	@Autowired
	private PartnerRepository partnerRepository;

	@Override
	public void savePartner(Partner partner) {
		PartnerEntity partnerEntity = partnerToEntity(partner);
		partnerRepository.save(partnerEntity);
		partner.setPartnerId(partnerEntity.getPartnerId());
	}

	@Override
	public Partner findByUserId(long userId) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(userId);
		PartnerEntity partnerEntity = partnerRepository.findByUserId(userEntity);
		if (partnerEntity == null) {
			return null;
		}
		return entityToPartner(partnerEntity);
	}

	@Override
	public int countVip() {
		return partnerRepository.countByType("VIP");
	}

	@Override
	public List<Partner> getByTypePending() {
		List<PartnerEntity> partnerEntities = partnerRepository.findByType("PENDING");
		List<Partner> partners = new ArrayList<>();
		for (PartnerEntity partnerEntity : partnerEntities) {
			partners.add(entityToPartner(partnerEntity));
		}
		return partners;
	}

	@Override
	public void updateTypeToRegular() {
		partnerRepository.updateType("PENDING", "REGULAR");
	}

	@Override
	public void updateType(Partner partner) {
		PartnerEntity partnerEntity = partnerRepository.findById(partner.getPartnerId()).orElseThrow(() -> new RuntimeException("Partner not found"));
		partnerEntity.setType(partner.getType());
		partnerRepository.save(partnerEntity);
	}

	@Override
	public Partner findByUserId(User user) {
		PartnerEntity partnerEntity = partnerRepository.findByUserId(userToEntity(user));
		if (partnerEntity == null) {
			return null;
		}
		return entityToPartner(partnerEntity);
	}


	private PartnerEntity partnerToEntity(Partner partner) {
		PartnerEntity partnerEntity = new PartnerEntity();
		partnerEntity.setAmount(partner.getAmount());
		partnerEntity.setType(partner.getType());
		partnerEntity.setDateCreated(partner.getDateCreated());
		partnerEntity.setUserId(userToEntity(partner)); // Convert User to UserEntity
		return partnerEntity;
	}

	private Partner entityToPartner(PartnerEntity partnerEntity) {
		 Partner partner = new Partner();
		    partner.setPartnerId(partnerEntity.getPartnerId());
		    partner.setAmount(partnerEntity.getAmount());
		    partner.setType(partnerEntity.getType());
		    partner.setDateCreated(partnerEntity.getDateCreated());
		    
		    partner.setUserId(partnerEntity.getUserId().getUserId()); // Directly set User's ID
		    partner.setUserName(partnerEntity.getUserId().getUserName()); // Directly set User's Name
		    partner.setPassword(partnerEntity.getUserId().getPassword()); // Directly set User's Password
		    partner.setRole(partnerEntity.getUserId().getRole()); // Directly set User's Role
		    
		    partner.setName(partnerEntity.getUserId().getPersonId().getName()); // Directly set Person's Name
		    partner.setCellPhone(partnerEntity.getUserId().getPersonId().getCellPhone()); // Directly set Person's CellPhone
		    partner.setDocument(partnerEntity.getUserId().getPersonId().getDocument()); // Directly set Person's Document
		    partner.setPersonId(partnerEntity.getUserId().getPersonId().getPersonId());

		return partner;
	}

	private UserEntity userToEntity(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserId(user.getUserId());
		userEntity.setUserName(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setRole(user.getRole());
		userEntity.setPersonId(personToEntity(user)); // Add Person to UserEntity if needed
		return userEntity;
	}

	private User entityToUser(UserEntity userEntity) {
		User user = new User();
		user.setUserId(userEntity.getUserId());
		user.setUserName(userEntity.getUserName());
		user.setPassword(userEntity.getPassword());
		user.setRole(userEntity.getRole());
		user.setName(userEntity.getPersonId().getName());
		user.setCellPhone(userEntity.getPersonId().getCellPhone());
		user.setDocument(userEntity.getPersonId().getDocument());
		return user;
	}

	private PersonEntity personToEntity(User user) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setName(user.getName());
		personEntity.setCellPhone(user.getCellPhone());
		personEntity.setDocument(user.getDocument());
		return personEntity;
	}
}
