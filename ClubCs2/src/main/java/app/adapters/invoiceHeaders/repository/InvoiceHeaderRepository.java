package app.adapters.invoiceHeaders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import app.adapters.guests.entity.GuestEntity;
import app.adapters.invoiceHeaders.entity.InvoiceHeaderEntity;
import app.adapters.partners.entity.PartnerEntity;
import app.adapters.persons.entity.PersonEntity;

public interface InvoiceHeaderRepository extends JpaRepository<InvoiceHeaderEntity, Long> {

    List<InvoiceHeaderEntity> findByPartner(PartnerEntity partner);

    List<InvoiceHeaderEntity> findByPerson(PersonEntity person);


    @Query("SELECT SUM(i.amount) FROM InvoiceHeaderEntity i WHERE i.partner = :partner")
    double sumAmountByPartner(@Param("partner") PartnerEntity partner);
}
