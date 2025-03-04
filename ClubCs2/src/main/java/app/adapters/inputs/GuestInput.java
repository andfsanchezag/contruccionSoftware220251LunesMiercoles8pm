package app.adapters.inputs;

import org.springframework.stereotype.Component;

import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Setter
@Getter
@NoArgsConstructor
public class GuestInput implements InputPort {

	@Override
	public void menu() throws Exception {
		System.out.println("rol Invitado");
		
	}

}
