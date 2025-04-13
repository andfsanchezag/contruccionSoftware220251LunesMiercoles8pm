package app.adapters.inputs.utils;

import org.springframework.stereotype.Component;

@Component
public class SimpleValidator {

    public String stringValidator(String value, String element) throws Exception {
        if (value == null || value.trim().isEmpty()) {
            throw new Exception(element + " no tiene un valor válido");
        }
        return value.trim();
    }

    public Long longValidator(String value, String element) throws Exception {
        try {
            return Long.parseLong(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new Exception(element + " debe ser un valor numérico entero");
        }
    }

    public Integer intValidator(String value, String element) throws Exception {
        try {
            return Integer.parseInt(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new Exception(element + " debe ser un valor numérico entero");
        }
    }

    public Double doubleValidator(String value, String element) throws Exception {
        try {
            return Double.parseDouble(stringValidator(value, element));
        } catch (NumberFormatException e) {
            throw new Exception(element + " debe ser un valor numérico decimal");
        }
    }
}
