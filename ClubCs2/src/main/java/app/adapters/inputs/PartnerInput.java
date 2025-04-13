package app.adapters.inputs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.InvoiceDetailValidator;
import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.Guest;
import app.domain.models.InvoiceDetail;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.domain.services.PartnerService;
import app.ports.InputPort;

@Component
public class PartnerInput implements InputPort {
	
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private InvoiceDetailValidator invoiceDetailValidator;
	private User partner;

	private final String MENU = "Ingrese la opción:"
			+ "\n 1. Registrar consumo."
			+ "\n 2. Registrar invitado."
			+ "\n 3. Activar invitado."
			+ "\n 4. Inactivar invitado."
			+ "\n 5. Cerrar sesión.";

	@Override
	public void menu() {
		boolean sesion = true;
		while (sesion) {
			sesion = options();
		}
	}

	private boolean options() {
		try {
			System.out.println(MENU);
			String option = Utils.getReader().nextLine();
			switch (option) {
			case "1":
				this.registerConsumption();
				return true;
			case "2":
				this.registerGuest();
				return true;
			case "3":
				this.activateGuest();
				return true;
			case "4":
				this.inactivateGuest();
				return true;
			case "5":
				System.out.println("Se ha cerrado sesión.");
				return false;
			default:
				System.out.println("Opción no válida.");
				return true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return true;
		}
	}

	private void registerConsumption() throws Exception {

		List<InvoiceDetail> invoiceDetails = new ArrayList<>();
		String continuar = "si";
		while (continuar.equalsIgnoreCase("si")) {
			InvoiceDetail invoiceDetail = new InvoiceDetail();
			System.out.println("Ingrese el nombre del consumo:");
			invoiceDetail.setDescription(invoiceDetailValidator.descriptionValidator(Utils.getReader().nextLine()));
			System.out.println("Ingrese el valor del consumo:");
			invoiceDetail.setAmount(invoiceDetailValidator.amountValidator(Utils.getReader().nextLine()));
			invoiceDetails.add(invoiceDetail);

			System.out.println("¿Desea ingresar otro consumo? (si/no):");
			continuar = Utils.getReader().nextLine();
		}

		partnerService.partnerConsumption(partner, invoiceDetails);
	}

	private void registerGuest() throws Exception {
		System.out.println("Ingrese el nombre del invitado:");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el documento del invitado:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el número celular del invitado:");
		long cellPhone = personValidator.cellPhoneValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el nombre de usuario del invitado:");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese la contraseña del invitado:");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());

		Partner partner = new Partner();
		partner.setDocument(this.partner.getDocument());

		Guest guest = new Guest();
		guest.setName(name);
		guest.setDocument(document);
		guest.setCellPhone(cellPhone);
		guest.setUserName(userName);
		guest.setPassword(password);
		guest.setRole("guest");
		guest.setPartner(partner);

		partnerService.registerPartner(guest);
	}

	private void activateGuest() throws Exception {
		System.out.println("Ingrese el documento del invitado:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());

		Person person = new Person();
		person.setDocument(document);
		partnerService.activateGuest(person);
	}

	private void inactivateGuest() throws Exception {
		System.out.println("Ingrese el documento del invitado:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());

		Person person = new Person();
		person.setDocument(document);
		partnerService.inActivateGuest(person);
	}
	
	public void setUser(User user) {
		this.partner =  user;
	}
}
