package app.domain.services;

import java.sql.Date;
import java.util.List;

import app.domain.models.Guest;
import app.domain.models.InvoiceDetail;
import app.domain.models.InvoiceHeader;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.GuestPort;
import app.ports.InvoiceDetailPort;
import app.ports.InvoiceHeaderPort;
import app.ports.PersonPort;
import app.ports.UserPort;

public class GuestService {
	private PersonPort personPort;
	private UserPort userPort;
	private GuestPort guestPort;
	private InvoiceHeaderPort invoiceHeaderPort;
	private InvoiceDetailPort invoiceDetailPort;
	
	public void guestConsumption(Person person, List<InvoiceDetail> invoiceDetails) throws Exception {
		person = personPort.findByDocument(person.getDocument());
		if (person==null) {
			throw new Exception("no existe la persona con esa cedula.");
		}
		User user = userPort.findByPersonId(person.getPersonId());
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
		InvoiceHeader invoiceHeader = new InvoiceHeader();
		invoiceHeader.setPerson(guest);
		invoiceHeader.setPartner(guest.getPartner());
		invoiceHeader.setDateCreated(new Date(System.currentTimeMillis()));
		invoiceHeader.setStatus(false);
		double total =0;
		for(InvoiceDetail invoiceDetail: invoiceDetails) {
			total+=invoiceDetail.getAmount();
			invoiceDetail.setInvoiceHeader(invoiceHeader);
		}
		invoiceHeader.setAmount(total);
		invoiceHeaderPort.save(invoiceHeader);
		for(InvoiceDetail invoiceDetail: invoiceDetails) {
			invoiceDetailPort.save(invoiceDetail);
		} 	
	}

}
