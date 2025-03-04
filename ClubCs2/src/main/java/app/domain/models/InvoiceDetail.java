package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class InvoiceDetail {
	private long invoiceDetailId;
	private InvoiceHeader invoiceHeader;
	private int item;
	private String description;
	private double amount;
	public long getInvoiceDetailId() {
		return invoiceDetailId;
	}
	public void setInvoiceDetailId(long invoiceDetailId) {
		this.invoiceDetailId = invoiceDetailId;
	}
	public InvoiceHeader getInvoiceHeader() {
		return invoiceHeader;
	}
	public void setInvoiceHeader(InvoiceHeader invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}
	public int getItem() {
		return item;
	}
	public void setItem(int item) {
		this.item = item;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	
}
