package app.adapters.invoiceDetails.entity;

import app.adapters.invoiceHeaders.entity.InvoiceHeaderEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invoice_details")
public class InvoiceDetailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "invoice_detail_id")
    private long invoiceDetailId;

    @ManyToOne
    @JoinColumn(name = "invoice_header_id", nullable = false)
    private InvoiceHeaderEntity invoiceHeader;

    @Column(name = "item", nullable = false)
    private int item;

    @Column(name = "description", nullable = false, length = 255)
    private String description;

    @Column(name = "amount", nullable = false)
    private double amount;

    // Getters and Setters
    public long getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(long invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public InvoiceHeaderEntity getInvoiceHeader() {
        return invoiceHeader;
    }

    public void setInvoiceHeader(InvoiceHeaderEntity invoiceHeader) {
        this.invoiceHeader = invoiceHeader;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
