/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface InvoiceHeaderPort {
    public List<InvoiceHeader> getAllInvoices();

    public List<InvoiceHeader> getInvoicesByPartner(Partner partner);

    public List<InvoiceHeader> getInvoicesByPerson(Person person);

    public double getTotalAmountPayed(Partner partner);

	public void save(InvoiceHeader invoiceHeader);
}
