package app.domain.models;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class InvoiceHeader {
	 private long invoiceHeaderId;
	 private Person person;
	 private Partner partner;
	 private Date dateCreated;
	 private double amount;
	 private boolean status;
	public long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}
	public void setInvoiceHeaderId(long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	 
	 
 
}
