package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

public class Guest extends User {
	private long guestId;
	private Partner partner;
	private boolean status;
	public Guest(long personId, long document, String name, long cellPhone, long userId, String userName,
			String password, String role, long guestId, Partner partner, boolean status) {
		super(personId, document, name, cellPhone, userId, userName, password, role);
		this.guestId = guestId;
		this.partner = partner;
		this.status = status;
	}
	
	

}
