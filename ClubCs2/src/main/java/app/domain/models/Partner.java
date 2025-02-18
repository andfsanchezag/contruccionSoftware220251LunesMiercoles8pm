package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Partner extends User {
	private long partnerId;
	private double amount;
	private String type;
	private Timestamp dateCreated;
        private double totalAmountPayed;
	
	public Partner(long personId, long document, String name, long cellPhone, long userId, String userName,
			String password, String role, long partnerId, double amount, String type, Timestamp dateCreated) {
		super(personId, document, name, cellPhone, userId, userName, password, role);
		this.partnerId = partnerId;
		this.amount = amount;
		this.type = type;
		this.dateCreated = dateCreated;
	}
	
	
	
	
}
