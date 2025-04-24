package app.adapters.rest.utils;

import org.springframework.stereotype.Component;

import app.Exceptions.InputsException;

@Component
public class SimpleValidator {

    public String stringValidator(String value, String element) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new InputsException(element + " no tiene un valor válido");
        }
        return value.trim();
    }

    public Long longValidator(String value, String element) throws Exception {
        try {
            return Long.parseLong(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico entero");
        }
    }

    public Integer intValidator(String value, String element) throws Exception {
        try {
            return Integer.parseInt(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico entero");
        }
    }

    public Double doubleValidator(String value, String element) throws Exception {
        try {
            return Double.parseDouble(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new InputsException(element + " debe ser un valor numérico decimal");
        }
    }
}
