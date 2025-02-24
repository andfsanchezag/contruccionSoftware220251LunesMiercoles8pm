package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvoiceDetail {
	private long invoiceDetailId;
	private InvoiceHeader invoiceHeader;
	private int item;
	private String description;
	private double amount;
	
}
