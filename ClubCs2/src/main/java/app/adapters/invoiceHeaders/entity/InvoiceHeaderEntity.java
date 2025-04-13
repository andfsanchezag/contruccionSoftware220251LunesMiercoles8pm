package app.adapters.invoiceHeaders.entity;

import jakarta.persistence.*;
import java.sql.Date;
import app.adapters.partners.entity.PartnerEntity;
import app.adapters.persons.entity.PersonEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "invoice_header")
@Getter
@Setter
@NoArgsConstructor
public class InvoiceHeaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_header_id")
    private long invoiceHeaderId;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @ManyToOne
    @JoinColumn(name = "partner_id")
    private PartnerEntity partner;

    @Column(name = "date_created")
    private Date dateCreated;

    @Column(name = "amount")
    private double amount;

    @Column(name = "status")
    private boolean status;

	public long getInvoiceHeaderId() {
		return invoiceHeaderId;
	}

	public void setInvoiceHeaderId(long invoiceHeaderId) {
		this.invoiceHeaderId = invoiceHeaderId;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public PartnerEntity getPartner() {
		return partner;
	}

	public void setPartner(PartnerEntity partner) {
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
