package app.adapters.inputs;

import app.ports.InputPort;

public class GuestInput implements InputPort {

	@Override
	public void menu() throws Exception {
		System.out.println("rol Invitado");
		
	}

}
