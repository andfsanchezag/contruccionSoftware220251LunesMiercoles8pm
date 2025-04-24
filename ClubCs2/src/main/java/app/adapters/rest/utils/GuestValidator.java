package app.adapters.rest.utils;

import org.springframework.stereotype.Component;

@Component
public class GuestValidator extends SimpleValidator {

    public String nameValidator(String value) throws Exception {
        return stringValidator(value, "nombre del invitado");
    }

    public Long documentValidator(String value) throws Exception {
        return longValidator(value, "documento del invitado");
    }

    public Long cellPhoneValidator(String value) throws Exception {
        return longValidator(value, "celular del invitado");
    }

    public String userNameValidator(String value) throws Exception {
        return stringValidator(value, "nombre de usuario del invitado");
    }

    public String passwordValidator(String value) throws Exception {
        return stringValidator(value, "contraseña del invitado");
    }
}
