/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;

import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ESTUDIANTES
 */
@NoArgsConstructor
@Setter
@Getter
public class InvoiceHeader {
    private long invoiceHeaderId;
    private Person Person;
    private Partner partner;
    private Date createdDate;
    private double amount;
    private boolean status;

    public InvoiceHeader(long invoiceHeaderId, Person Person, Partner partner, Date createdDate, double amount, boolean status) {
        this.invoiceHeaderId = invoiceHeaderId;
        this.Person = Person;
        this.partner = partner;
        this.createdDate = createdDate;
        this.amount = amount;
        this.status = status;
    }
    
    
}
