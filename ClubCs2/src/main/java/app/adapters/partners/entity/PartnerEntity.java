package app.adapters.partners.entity;

import java.sql.Timestamp;

import app.adapters.users.entity.UserEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="partner")
public class PartnerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "guest_id")
    private long partnerId;
	@Column(name="amount")
    private double amount;
	@Column(name="type")
    private String type;
	@Column(name="date_created")
    private Timestamp dateCreated;
	@JoinColumn(name="user_id")
	@OneToOne
    private UserEntity userId;
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
	public UserEntity getUserId() {
		return userId;
	}
	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	
}
