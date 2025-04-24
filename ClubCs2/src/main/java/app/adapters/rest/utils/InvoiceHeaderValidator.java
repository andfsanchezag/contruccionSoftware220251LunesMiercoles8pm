package app.adapters.rest.utils;

import org.springframework.stereotype.Component;

@Component
public class InvoiceHeaderValidator extends SimpleValidator {

    public Long invoiceIdValidator(String value) throws Exception {
        return longValidator(value, "ID de la factura");
    }

    public String dateValidator(String value) throws Exception {
        return stringValidator(value, "fecha de la factura");
    }

    public Double amountValidator(String value) throws Exception {
        return doubleValidator(value, "monto de la factura");
    }
}
