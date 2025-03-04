package app.adapters.inputs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.Partner;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput  implements InputPort{
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;

	private final String MENU = "Ingrese la opcion:"
			+ " \n 1. para crear Socios."
			+ " \n 2. ver facturas del club."
			+ " \n 3. ver facturas de un socio."
			+ " \n 4. ver facturas de una persona."
			+ " \n 5. promover socios.";
	
	public void menu() {
		System.out.println(MENU);
		String option = Utils.getReader().nextLine();
		switch (option){
		case "1":{
			try {
				this.createPartner();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		}
		default :
			System.out.println("opcion no valida");
		}
	}
	
	private void createPartner()  throws Exception{
		System.out.println("ingrese el nombre del socio");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el documento del socio");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el numero celular del socio");
		long cellPhone = personValidator.cellPhoneValidator(Utils.getReader().nextLine());
		System.out.println("ingrese el userName del socio");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("ingrese la contraseña socio");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());
		Partner partner = new Partner();
		partner.setDocument(document);
		partner.setName(name);
		partner.setCellPhone(cellPhone);
		partner.setUserName(userName);
		partner.setPassword(password);
		partner.setRole("partner");
		
	}
}
