package app.adapters.invoiceDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.adapters.invoiceDetails.entity.InvoiceDetailEntity;

@Repository
public interface InvoiceDetailRepository extends JpaRepository<InvoiceDetailEntity, Long> {
}
