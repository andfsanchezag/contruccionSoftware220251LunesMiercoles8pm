package app.adapters.inputs;

import org.springframework.stereotype.Component;

import app.domain.models.Guest;
import app.domain.models.User;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class GuestInput implements InputPort {
	private User guest;
	@Override
	public void menu() throws Exception {
		System.out.println("rol Invitado");
		
	}
	public void setUser(User admin) {
		this.guest =admin;
	}

}
