package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Partner extends User {
	private long partnerId;
	private double amount;
	private String type;
	private Timestamp dateCreated;
    private double totalAmountPayed;
	public long getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(long partnerId) {
		this.partnerId = partnerId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Timestamp getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Timestamp dateCreated) {
		this.dateCreated = dateCreated;
	}
	public double getTotalAmountPayed() {
		return totalAmountPayed;
	}
	public void setTotalAmountPayed(double totalAmountPayed) {
		this.totalAmountPayed = totalAmountPayed;
	}
	
    
	
}
