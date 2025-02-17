/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;

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
public class InvoiceDetail {
    private long invoiceDetailId;
    private int item;
    private String description;
    private double amount;
    private InvoiceHeader invoiceHeader;

    public InvoiceDetail(long invoiceDetailId, int item, String description, double amount, InvoiceHeader invoiceHeader) {
        this.invoiceDetailId = invoiceDetailId;
        this.item = item;
        this.description = description;
        this.amount = amount;
        this.invoiceHeader = invoiceHeader;
    }
    
    
}
