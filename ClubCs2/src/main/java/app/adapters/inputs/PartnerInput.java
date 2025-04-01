package app.adapters.inputs;

import org.springframework.stereotype.Component;

import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class PartnerInput implements InputPort {

	@Override
	public void menu() throws Exception {
		System.out.println("rol socio");
		
	}

}
