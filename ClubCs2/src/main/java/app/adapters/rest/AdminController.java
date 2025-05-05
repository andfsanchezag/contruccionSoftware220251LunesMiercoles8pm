package app.adapters.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import app.Exceptions.BusinessException;
import app.Exceptions.InputsException;
import app.Exceptions.NotFoundException;
import app.adapters.rest.request.PartnerRequest;
import app.adapters.rest.response.UserResponse;
import app.adapters.rest.utils.PersonValidator;
import app.adapters.rest.utils.UserValidator;
import app.domain.models.Partner;
import app.domain.models.User;
import app.domain.services.AdminService;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminservice;
	@Autowired
	private PersonValidator personValidator;
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/")
	public String itsAlive() {
		return "i'm alive";
	}
	
	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}
	
	@PostMapping("/partner")
	public ResponseEntity createPartner(@RequestBody PartnerRequest request){
		try {
		System.out.println(request.toString());
		Partner partner = new Partner();
		partner.setName(personValidator.nameValidator(request.getName()));
		partner.setUserName(userValidator.userNameValidator(request.getUserName()));
		partner.setPassword(userValidator.passwordValidator(request.getPassword()));
		if(request.getCellphone()==0) {
			throw new InputsException("el numero de celular no puede ser cero");
		}
		partner.setCellPhone(request.getCellphone());
		if(request.getDocument()==0) {
			throw new InputsException("el numero de documento no puede ser cero");
		}
		partner.setDocument(request.getDocument());
		adminservice.registerPartner(partner);
		return new ResponseEntity("se ha creado el socio",HttpStatus.OK);
		}catch(BusinessException be) {
			return new ResponseEntity(be.getMessage(),HttpStatus.CONFLICT);
		}catch(InputsException ie) {
			return new ResponseEntity(ie.getMessage(),HttpStatus.BAD_REQUEST);
		}catch(Exception e) {
			return new ResponseEntity(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user")
	public ResponseEntity getUsers() {
		try {
			List<User> users = adminservice.getUsers();
			List<UserResponse> usersResponse = new ArrayList<UserResponse>(); 
			for(User user : users) {
				usersResponse.add(adapter(user));
			}
			return new ResponseEntity(usersResponse, HttpStatus.NOT_FOUND);
		}catch (NotFoundException NFe) {
			return new ResponseEntity(NFe.getMessage(), HttpStatus.NOT_FOUND);
		}  catch (BusinessException be) {
			return new ResponseEntity(be.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/user/{document}")
	public ResponseEntity getUser(@PathVariable long document) {
		try {
			User user = adminservice.getUser(document);
			UserResponse usersResponse= adapter(user);
			return new ResponseEntity(usersResponse, HttpStatus.NOT_FOUND);
		}catch (NotFoundException NFe) {
			return new ResponseEntity(NFe.getMessage(), HttpStatus.NOT_FOUND);
		}  catch (BusinessException be) {
			return new ResponseEntity(be.getMessage(), HttpStatus.CONFLICT);
		} catch (Exception e) {
			return new ResponseEntity(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	private UserResponse adapter(User user) {
		UserResponse userResponse = new UserResponse();
		userResponse.setCellphone(user.getCellPhone());
		userResponse.setRole(user.getRole());
		userResponse.setDocument(user.getDocument());
		userResponse.setUserName(user.getUserName());
		userResponse.setName(user.getName());
		return userResponse;
	}


}
