package app.adapters.inputs.utils;

import org.springframework.stereotype.Component;

@Component
public class PersonValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator(value, "nombre de la persona ");
	}
	
	public long documentValidator(String value)throws Exception {
		return longValidator(value, " numero de documento ");
	}
	
	public long cellPhoneValidator(String value)throws Exception {
		return longValidator(value, " numero de celular ");
	}
}
