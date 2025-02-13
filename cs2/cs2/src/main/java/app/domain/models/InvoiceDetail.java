package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class InvoiceDetail {
	private long invoiceDetailId;
	private InvoiceHeader inoviceHeader;
	private int item;
	private String description;
	private double amount;
	
	public InvoiceDetail(long invoiceDetailId, InvoiceHeader inoviceHeader, int item, String description,
			double amount) {
		super();
		this.invoiceDetailId = invoiceDetailId;
		this.inoviceHeader = inoviceHeader;
		this.item = item;
		this.description = description;
		this.amount = amount;
	}
	
	
}
