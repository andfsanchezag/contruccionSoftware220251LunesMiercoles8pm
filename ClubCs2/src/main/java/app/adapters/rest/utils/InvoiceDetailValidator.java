package app.adapters.rest.utils;

import org.springframework.stereotype.Component;

@Component
public class InvoiceDetailValidator extends SimpleValidator {

    public Long invoiceDetailIdValidator(String value) throws Exception {
        return longValidator(value, "ID del detalle de la factura");
    }

    public Integer itemValidator(String value) throws Exception {
        return intValidator(value, "ítem del detalle");
    }

    public String descriptionValidator(String value) throws Exception {
        return stringValidator(value, "descripción del detalle");
    }

    public Double amountValidator(String value) throws Exception {
        return doubleValidator(value, "monto del detalle");
    }
}
