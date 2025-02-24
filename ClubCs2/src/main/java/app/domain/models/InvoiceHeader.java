package app.domain.models;

import java.sql.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvoiceHeader {
	 private long invoiceHeaderId;
	 private Person person;
	 private Partner partner;
	 private Date dateCreated;
	 private double amount;
	 private boolean status;
 
}
