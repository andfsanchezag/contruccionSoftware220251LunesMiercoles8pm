package app.adapters.inputs;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapters.inputs.utils.PersonValidator;
import app.adapters.inputs.utils.UserValidator;
import app.adapters.inputs.utils.Utils;
import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.domain.services.AdminService;
import app.ports.InputPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Component
public class AdminInput implements InputPort {

	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private AdminService adminService;
	private User admin;

	private final String MENU = "Ingrese la opcion:"
			+ " \n 1. para crear Socios."
			+ " \n 2. ver facturas del club."
			+ " \n 3. ver facturas de un socio."
			+ " \n 4. ver facturas de una persona."
			+ " \n 5. promover socios."
			+ " \n 6. cerrar sesion.";

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
				this.createPartner();
				return true;
			case "2":
				this.viewAllInvoices();
				return true;
			case "3":
				this.viewInvoicesByPartner();
				return true;
			case "4":
				this.viewInvoicesByPerson();
				return true;
			case "5":
				this.promotePartnersToVip();
				return true;
			case "6":
				System.out.println("Se ha cerrado sesión");
				return false;
			default:
				System.out.println("Opción no válida");
				return true;
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			return true;
		}
	}

	private void createPartner() throws Exception {
		System.out.println("Ingrese el nombre del socio:");
		String name = personValidator.nameValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el documento del socio:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el número celular del socio:");
		long cellPhone = personValidator.cellPhoneValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese el userName del socio:");
		String userName = userValidator.userNameValidator(Utils.getReader().nextLine());
		System.out.println("Ingrese la contraseña del socio:");
		String password = userValidator.passwordValidator(Utils.getReader().nextLine());

		Partner partner = new Partner();
		partner.setDocument(document);
		partner.setName(name);
		partner.setCellPhone(cellPhone);
		partner.setUserName(userName);
		partner.setPassword(password);
		partner.setRole("partner");

		adminService.registerPartner(partner);
		System.out.println("Socio creado exitosamente.");
	}

	private void viewAllInvoices() throws Exception {
		List<InvoiceHeader> invoices = adminService.getInvoiceHeader(null);
		if (invoices.isEmpty()) {
			System.out.println("No hay facturas registradas.");
		} else {
			invoices.forEach(invoice -> System.out.println(invoice.toString()));
		}
	}

	private void viewInvoicesByPartner() throws Exception {
		System.out.println("Ingrese el documento del socio:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());

		Person person = new Person();
		person.setDocument(document);

		List<InvoiceHeader> invoices = adminService.getInvoiceHeader(person);
		if (invoices.isEmpty()) {
			System.out.println("Este socio no tiene facturas.");
		} else {
			invoices.forEach(invoice -> System.out.println(invoice.toString()));
		}
	}

	private void viewInvoicesByPerson() throws Exception {
		System.out.println("Ingrese el documento de la persona:");
		long document = personValidator.documentValidator(Utils.getReader().nextLine());

		Person person = new Person();
		person.setDocument(document);

		List<InvoiceHeader> invoices = adminService.getInvoiceHeader(person);
		if (invoices.isEmpty()) {
			System.out.println("Esta persona no tiene facturas.");
		} else {
			invoices.forEach(invoice -> System.out.println(invoice.toString()));
		}
	}

	private void promotePartnersToVip() {
		try {
			adminService.promotionToVip();
			System.out.println("Promoción a VIP ejecutada correctamente.");
		} catch (Exception e) {
			System.out.println("No se pudo ejecutar la promoción: " + e.getMessage());
		}
	}

	
	public void setUser(User admin) {
		this.admin = admin;
	}
	
	
}
