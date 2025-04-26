package app.domain.services;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.Exceptions.BusinessException;
import app.domain.models.Guest;
import app.domain.models.InvoiceDetail;
import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.GuestPort;
import app.ports.InvoiceDetailPort;
import app.ports.InvoiceHeaderPort;
import app.ports.PartnerPort;
import app.ports.PersonPort;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Setter
@Getter
@NoArgsConstructor
public class PartnerService {

	@Autowired
	private PersonPort personPort;
	@Autowired
	private UserPort userPort;
	@Autowired
	private PartnerPort partnerPort;
	@Autowired
	private InvoiceHeaderPort invoiceHeaderPort;
	@Autowired
	private InvoiceDetailPort invoiceDetailPort;
	@Autowired
	private GuestPort guestPort;

	public void partnerConsumption(Person person, List<InvoiceDetail> invoiceDetails) throws Exception {
		person = personPort.findByDocument(person.getDocument());
		if (person == null) {
			throw new Exception("no existe la persona con esa cedula.");
		}
		User user = userPort.findByPersonId(person);
		if (user == null) {
			throw new Exception("no existe un usuario con esa cedula.");
		}
		if (!user.getRole().equals("partner")) {
			throw new Exception("la cedula no pertenece a un socio.");
		}
		Partner partner = partnerPort.findByUserId(user);
		if (partner == null) {
			throw new Exception("no existe un socio con esa cedula.");
		}

		InvoiceHeader invoiceHeader = new InvoiceHeader();
		invoiceHeader.setPerson(partner);
		invoiceHeader.setPartner(partner);
		invoiceHeader.setDateCreated(new Date(System.currentTimeMillis()));
		invoiceHeader.setStatus(false);
		double total = 0;
		for (InvoiceDetail invoiceDetail : invoiceDetails) {
			total += invoiceDetail.getAmount();
			invoiceDetail.setInvoiceHeader(invoiceHeader);
		}
		invoiceHeader.setAmount(total);
		invoiceHeaderPort.save(invoiceHeader);
		for (InvoiceDetail invoiceDetail : invoiceDetails) {
			invoiceDetailPort.save(invoiceDetail);
		}
	}

	public void registerPartner(Guest guest) throws Exception {
		if (personPort.existPerson(guest.getDocument())) {
			throw new BusinessException("ya existe una persona con esa cedula");
		}
		if (userPort.existUserName(guest.getUserName())) {
			throw new BusinessException("ya existe ese username registrado");
		}
		Person person = personPort.findByDocument(guest.getPartner().getDocument());
		if (person == null) {
			throw new BusinessException("no existe la persona con esa cedula.");
		}
		User user = userPort.findByPersonId(person);
		if (user == null) {
			throw new BusinessException("no existe un usuario con esa cedula.");
		}
		Partner partner = partnerPort.findByUserId(user);
		if (partner == null) {
			throw new BusinessException("no existe un socio con esa cedula.");
		}
		guest.setRole("guest");
		guest.setPartner(partner);
		personPort.savePerson(guest);
		userPort.saveUser(guest);
		guestPort.save(guest);
	}

	public void activateGuest(Person person) throws Exception {
		person = personPort.findByDocument(person.getDocument());
		if (person==null) {
			throw new Exception("no existe la persona con esa cedula.");
		}
		User user = userPort.findByPersonId(person);
		if (user==null) {
			throw new Exception("no existe un usuario con esa cedula.");
		}
		if(!user.getRole().equals("guest")) {
			throw new Exception("la cedula no pertenece a un invitado.");
		}
		Guest guest = guestPort.findByUserId(user);
		if (guest==null) {
			throw new Exception("no existe un invitado con esa cedula.");
		}
		if(guest.isStatus()) {
			throw new Exception("invitado  esta activo.");
		}
		if(guest.getPartner().getType().equals("vip")){
			guest.setStatus(true);
			guestPort.save(guest);
			return;
		}
		List<Guest> guests = guestPort.findByPartnerIdAndStatusActive(guest.getPartner());
		if(guests.size()==3) {
			throw new Exception("no puede activar mas invitados");
		}
		guest.setStatus(true);
		guestPort.save(guest);
		
	}
	
	public void inActivateGuest(Person person) throws Exception {
		person = personPort.findByDocument(person.getDocument());
		if (person==null) {
			throw new Exception("no existe la persona con esa cedula.");
		}
		User user = userPort.findByPersonId(person);
		if (user==null) {
			throw new Exception("no existe un usuario con esa cedula.");
		}
		if(!user.getRole().equals("guest")) {
			throw new Exception("la cedula no pertenece a un invitado.");
		}
		Guest guest = guestPort.findByUserId(user);
		if (guest==null) {
			throw new Exception("no existe un invitado con esa cedula.");
		}
		if(!guest.isStatus()) {
			throw new Exception("invitado no esta activo.");
		}
		
		guest.setStatus(false);
		guestPort.save(guest);	
	}
	
	

}
