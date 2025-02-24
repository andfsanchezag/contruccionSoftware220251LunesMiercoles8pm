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
}
