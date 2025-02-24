package app.adapters.guests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.guests.entity.GuestEntity;
import app.adapters.guests.repository.GuestRepository;
import app.adapters.partners.entity.PartnerEntity;
import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Guest;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.GuestPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Service
public class GuestAdapter implements GuestPort {
	@Autowired
	private GuestRepository guestRepository;

	@Override
	public Guest findByUserId(User userId) {
		UserEntity userEntity = userAdapter(userId);
		GuestEntity guestEntity = guestRepository.findByUserId(userEntity);
		if (guestEntity == null) {
			return null;
		}
		return guestAdapter(guestEntity);
	}

	
	@Override
	public void save(Guest guest) {
		GuestEntity guestEntity = guestAdapter(guest);
		guestRepository.save(guestEntity);
		guest.setGuestId(guestEntity.getGuestId());
	}

	private GuestEntity guestAdapter(Guest guest) {
		GuestEntity guestEntity = new GuestEntity();
		guestEntity.setStatus(guest.isStatus());
		guestEntity.setUserId(userAdapter(guest));
		guestEntity.setPartnerId(partnerAdapter(guest.getPartner()));
		return guestEntity;
	}

	private UserEntity userAdapter(User user) {
		UserEntity userEntity = new UserEntity();
		userEntity.setUserName(user.getUserName());
		userEntity.setUserId(user.getUserId());
		userEntity.setPassword(user.getPassword());
		userEntity.setPersonId(personAdarter(user));
		return userEntity;
	}

	private PersonEntity personAdarter(Person person) {
		PersonEntity personEntity = new PersonEntity();
		personEntity.setPersonId(person.getPersonId());
		personEntity.setName(person.getName());
		personEntity.setCellPhone(person.getCellPhone());
		personEntity.setDocument(person.getDocument());
		return personEntity;
	}

	private PartnerEntity partnerAdapter(Partner partner) {
		PartnerEntity partnerEntity = new PartnerEntity();
		partnerEntity.setUserId(userAdapter(partner));
		partnerEntity.setAmount(partner.getAmount());
		partnerEntity.setType(partner.getType());
		partnerEntity.setDateCreated(partner.getDateCreated());
		return partnerEntity;
	}
	
	private Guest guestAdapter(GuestEntity guestEntity) {
		Guest guest = new Guest();
		guest.setName(guestEntity.getUserId().getPersonId().getName());
		guest.setDocument(guestEntity.getUserId().getPersonId().getDocument());
		guest.setPersonId(guestEntity.getUserId().getPersonId().getPersonId());
		guest.setCellPhone(guestEntity.getUserId().getPersonId().getCellPhone());
		guest.setUserId(guestEntity.getUserId().getUserId());
		guest.setUserName(guestEntity.getUserId().getUserName());
		guest.setPassword(guestEntity.getUserId().getPassword());
		guest.setRole(guestEntity.getUserId().getRole());
		guest.setGuestId(guestEntity.getGuestId());
		guest.setStatus(guestEntity.isStatus());
		guest.setPartner(partnerAdapter(guestEntity.getPartnerId()));
		return guest;
	}
	
	private Partner partnerAdapter(PartnerEntity partnerEntity) {
		Partner partner = new Partner();
		partner.setName(partnerEntity.getUserId().getPersonId().getName());
		partner.setDocument(partnerEntity.getUserId().getPersonId().getDocument());
		partner.setPersonId(partnerEntity.getUserId().getPersonId().getPersonId());
		partner.setCellPhone(partnerEntity.getUserId().getPersonId().getCellPhone());
		partner.setUserId(partnerEntity.getUserId().getUserId());
		partner.setUserName(partnerEntity.getUserId().getUserName());
		partner.setPassword(partnerEntity.getUserId().getPassword());
		partner.setRole(partnerEntity.getUserId().getRole());
		partner.setAmount(partnerEntity.getAmount());
		partner.setPartnerId(partnerEntity.getPartnerId());
		partner.setType(partnerEntity.getType());
		partner.setDateCreated(partnerEntity.getDateCreated());
		return partner;
	}


}
