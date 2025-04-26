package app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.Exceptions.BusinessException;
import app.Exceptions.InputsException;
import app.adapters.rest.request.GuestRequest;
import app.adapters.rest.utils.PartnerValidator;
import app.adapters.rest.utils.PersonValidator;
import app.adapters.rest.utils.UserValidator;
import app.domain.models.Guest;
import app.domain.models.Partner;
import app.domain.services.PartnerService;

@RestController
public class PartnerController {
	@Autowired
	private PartnerService partnerService;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	@Autowired
	private PartnerValidator partnerValidator;
	
	@PostMapping("/guest")
	public ResponseEntity createGuest(@RequestBody GuestRequest request) {
		try {
			System.out.println(request.toString());
			Guest guest = new Guest();
			guest.setName(personValidator.nameValidator(request.getName()));
			guest.setUserName(userValidator.userNameValidator(request.getUserName()));
			guest.setPassword(userValidator.passwordValidator(request.getPassword()));
			if(request.getCellphone()==0) {
				throw new InputsException("el numero de celular no puede ser cero");
			}
			guest.setCellPhone(request.getCellphone());
			if(request.getDocument()==0) {
				throw new InputsException("el numero de documento no puede ser cero");
			}
			guest.setDocument(request.getDocument());
			Partner partner = new Partner();
			if(request.getPartnerDocument()==0) {
				throw new InputsException("el numero de documento no puede ser cero");
			}
			partner.setDocument(request.getPartnerDocument());
			guest.setPartner(partner);
			partnerService.registerPartner(guest);
			return new ResponseEntity("se ha creado el socio",HttpStatus.OK);
			}catch(BusinessException be) {
				return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
			}catch(InputsException ie) {
				return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
			}catch(Exception e) {
				return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			}
	}
}
