package app.adapters.rest.utils;

import org.springframework.stereotype.Component;

@Component
public class PartnerValidator extends SimpleValidator {

    public Double amountValidator(String value) throws Exception {
        return doubleValidator(value, "monto del partner");
    }

    public String typeValidator(String value) throws Exception {
        return stringValidator(value, "tipo de partner");
    }

    public String dateValidator(String value) throws Exception {
        return stringValidator(value, "fecha de creación del partner");
    }
}
