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
@Setter
@Getter
@NoArgsConstructor
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

}
