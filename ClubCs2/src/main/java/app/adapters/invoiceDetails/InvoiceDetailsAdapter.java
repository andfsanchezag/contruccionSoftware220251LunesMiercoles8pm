package app.adapters.invoiceDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.adapters.invoiceDetails.entity.InvoiceDetailEntity;
import app.adapters.invoiceDetails.repository.InvoiceDetailRepository;
import app.adapters.invoiceHeaders.entity.InvoiceHeaderEntity;
import app.domain.models.InvoiceDetail;
import app.domain.models.InvoiceHeader;
import app.ports.InvoiceDetailPort;

@Service
public class InvoiceDetailsAdapter implements InvoiceDetailPort {

    @Autowired
    private InvoiceDetailRepository invoiceDetailRepository;

    @Override
    public void save(InvoiceDetail invoiceDetail) {
        InvoiceDetailEntity entity = modelToEntity(invoiceDetail);
        invoiceDetailRepository.save(entity);
    }

    private InvoiceDetailEntity modelToEntity(InvoiceDetail model) {
        InvoiceDetailEntity entity = new InvoiceDetailEntity();
        entity.setInvoiceDetailId(model.getInvoiceDetailId());
        entity.setItem(model.getItem());
        entity.setDescription(model.getDescription());
        entity.setAmount(model.getAmount());
        InvoiceHeaderEntity headerEntity = new InvoiceHeaderEntity();
        headerEntity.setInvoiceHeaderId(model.getInvoiceHeader().getInvoiceHeaderId());
        entity.setInvoiceHeader(headerEntity);

        return entity;
    }

    private InvoiceDetail entityToModel(InvoiceDetailEntity entity) {
        InvoiceDetail model = new InvoiceDetail();
        model.setInvoiceDetailId(entity.getInvoiceDetailId());
        model.setItem(entity.getItem());
        model.setDescription(entity.getDescription());
        model.setAmount(entity.getAmount());
        InvoiceHeader header = new InvoiceHeader();
        header.setInvoiceHeaderId(entity.getInvoiceHeader().getInvoiceHeaderId());
        model.setInvoiceHeader(header);

        return model;
    }
}
