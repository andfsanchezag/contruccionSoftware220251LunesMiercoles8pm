package app.adapters.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Exceptions.BusinessException;
import app.domain.models.Guest;
import app.domain.services.GuestService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@RestController
public class GuestController {
	
	@Autowired
	private GuestService guestService;
	
	@PutMapping("/guest/{document}")
	public ResponseEntity convertToPartner(@PathVariable long document) {
		try {
			Guest guest = new Guest();
			guest.setDocument(document);
			guestService.convertToPartner(guest);
			return new ResponseEntity("se ha convertido el invitado", HttpStatus.ACCEPTED);
			} catch (BusinessException be) {
			return new ResponseEntity(be.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
