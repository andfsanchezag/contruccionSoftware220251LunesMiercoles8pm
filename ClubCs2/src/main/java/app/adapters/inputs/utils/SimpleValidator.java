package app.adapters.inputs.utils;

import org.springframework.stereotype.Component;

@Component
public  class SimpleValidator {
	
	public String stringValidator(String value, String element)throws Exception {
		if (value== null||value.equals("")) {
			throw new Exception(element + " no tiene un valor valido");
		}
		return value;
	}
	
	public Long longValidator(String value, String element)throws Exception{
		try {
			return Long.parseLong(stringValidator(value, element));
		}catch(Exception e) {
			throw new Exception(element + " debe ser un valor numerico");
		}
	}

}
