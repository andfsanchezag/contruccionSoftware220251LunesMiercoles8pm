package app.adapters.guests.entity;

import app.adapters.partners.entity.PartnerEntity;
import app.adapters.users.entity.UserEntity;
import app.domain.models.Partner;
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


@Table(name="guest")
public class GuestEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "guest_id")
	private long guestId;
	@JoinColumn(name="user_id")
	@OneToOne
	private UserEntity userId;
	@JoinColumn(name="partner_id")
	@OneToOne
	private PartnerEntity partnerId;
	@Column(name = "status")
	private boolean status;
	public long getGuestId() {
		return guestId;
	}
	public void setGuestId(long guestId) {
		this.guestId = guestId;
	}
	public UserEntity getUserId() {
		return userId;
	}
	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}
	public PartnerEntity getPartnerId() {
		return partnerId;
	}
	public void setPartnerId(PartnerEntity partnerId) {
		this.partnerId = partnerId;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
