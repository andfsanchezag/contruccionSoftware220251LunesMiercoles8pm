package app.adapters.invoiceHeaders;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.guests.entity.GuestEntity;
import app.adapters.invoiceHeaders.entity.InvoiceHeaderEntity;
import app.adapters.invoiceHeaders.repository.InvoiceHeaderRepository;
import app.adapters.partners.entity.PartnerEntity;
import app.adapters.persons.entity.PersonEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Guest;
import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.InvoiceHeaderPort;

@Service
public class InvoiceHeadersAdapter implements InvoiceHeaderPort {

    @Autowired
    private InvoiceHeaderRepository invoiceHeaderRepository;

    @Override
    public List<InvoiceHeader> getAllInvoices() {
        List<InvoiceHeaderEntity> entities = invoiceHeaderRepository.findAll();
        return entities.stream()
                       .map(this::entityToModel)
                       .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceHeader> getInvoicesByPartner(Partner partner) {
        PartnerEntity partnerEntity = partnerToEntity(partner);
        List<InvoiceHeaderEntity> entities = invoiceHeaderRepository.findByPartner(partnerEntity);
        return entities.stream()
                       .map(this::entityToModel)
                       .collect(Collectors.toList());
    }

    @Override
    public List<InvoiceHeader> getInvoicesByPerson(Person person) {
        PersonEntity personEntity = personToEntity(person);
        List<InvoiceHeaderEntity> entities = invoiceHeaderRepository.findByPerson(personEntity);
        return entities.stream()
                       .map(this::entityToModel)
                       .collect(Collectors.toList());
    }

    @Override
    public double getTotalAmountPayed(Partner partner) {
        PartnerEntity partnerEntity = partnerToEntity(partner); 
        return invoiceHeaderRepository.sumAmountByPartner(partnerEntity);
    }

    @Override
    public void save(InvoiceHeader invoiceHeader) {
        InvoiceHeaderEntity entity = modelToEntity(invoiceHeader); // Conversión privada
        invoiceHeaderRepository.save(entity);
    }

    @Override
    public List<InvoiceHeader> findByPersonId(Guest guest) {
        PersonEntity guestEntity = personToEntity(guest); // Conversión privada
        List<InvoiceHeaderEntity> entities = invoiceHeaderRepository.findByPerson(guestEntity);
        return entities.stream()
                       .map(this::entityToModel)
                       .collect(Collectors.toList());
    }


    private GuestEntity guestToEntity(Guest guest) {
        GuestEntity guestEntity = new GuestEntity();
        guestEntity.setStatus(guest.isStatus());
        guestEntity.setUserId(userToEntity(guest)); // Conversión privada de User a UserEntity
        guestEntity.setPartnerId(partnerToEntity(guest.getPartner())); // Conversión privada de Partner a PartnerEntity
        return guestEntity;
    }

    private PartnerEntity partnerToEntity(Partner partner) {
        PartnerEntity partnerEntity = new PartnerEntity();
        partnerEntity.setAmount(partner.getAmount());
        partnerEntity.setType(partner.getType());
        partnerEntity.setDateCreated(partner.getDateCreated());
        partnerEntity.setUserId(userToEntity(partner)); // Conversión privada de User a UserEntity
        partnerEntity.setPartnerId(partner.getPartnerId());
        return partnerEntity;
    }

    private Partner entityToPartner(PartnerEntity partnerEntity) {
        Partner partner = new Partner();
        partner.setPartnerId(partnerEntity.getPartnerId());
        partner.setAmount(partnerEntity.getAmount());
        partner.setType(partnerEntity.getType());
        partner.setDateCreated(partnerEntity.getDateCreated());

        // Convertir la entidad de User y Person directamente a Partner
        partner.setUserId(partnerEntity.getUserId().getUserId());
        partner.setUserName(partnerEntity.getUserId().getUserName());
        partner.setPassword(partnerEntity.getUserId().getPassword());
        partner.setRole(partnerEntity.getUserId().getRole());

        partner.setName(partnerEntity.getUserId().getPersonId().getName());
        partner.setCellPhone(partnerEntity.getUserId().getPersonId().getCellPhone());
        partner.setDocument(partnerEntity.getUserId().getPersonId().getDocument());

        return partner;
    }

    private UserEntity userToEntity(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(user.getUserId());
        userEntity.setUserName(user.getUserName());
        userEntity.setPassword(user.getPassword());
        userEntity.setRole(user.getRole());
        userEntity.setPersonId(personToEntity(user)); // Convertir Person a PersonEntity
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
        personEntity.setPersonId(user.getPersonId());
        return personEntity;
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
        guest.setPartner(entityToPartner(guestEntity.getPartnerId()));
        return guest;
    }

    private InvoiceHeader entityToModel(InvoiceHeaderEntity entity) {
        InvoiceHeader invoiceHeader = new InvoiceHeader();
        invoiceHeader.setInvoiceHeaderId(entity.getInvoiceHeaderId());
        invoiceHeader.setPerson(entityToPersonModel(entity.getPerson()));
        invoiceHeader.setPartner(entityToPartner(entity.getPartner()));
        invoiceHeader.setDateCreated(entity.getDateCreated());
        invoiceHeader.setAmount(entity.getAmount());
        invoiceHeader.setStatus(entity.isStatus());
        return invoiceHeader;
    }

    private InvoiceHeaderEntity modelToEntity(InvoiceHeader invoiceHeader) {
        InvoiceHeaderEntity entity = new InvoiceHeaderEntity();
        entity.setInvoiceHeaderId(invoiceHeader.getInvoiceHeaderId());
        entity.setPerson(personToEntity(invoiceHeader.getPerson()));
        entity.setPartner(partnerToEntity(invoiceHeader.getPartner()));
        entity.setDateCreated(invoiceHeader.getDateCreated());
        entity.setAmount(invoiceHeader.getAmount());
        entity.setStatus(invoiceHeader.isStatus());
        return entity;
    }

    private PersonEntity personToEntity(Person person) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setPersonId(person.getPersonId());
        personEntity.setName(person.getName());
        personEntity.setCellPhone(person.getCellPhone());
        personEntity.setDocument(person.getDocument());
        return personEntity;
    }

    private Person entityToPersonModel(PersonEntity entity) {
        Person person = new Person();
        person.setPersonId(entity.getPersonId());
        person.setName(entity.getName());
        person.setCellPhone(entity.getCellPhone());
        person.setDocument(entity.getDocument());
        return person;
    }
}
