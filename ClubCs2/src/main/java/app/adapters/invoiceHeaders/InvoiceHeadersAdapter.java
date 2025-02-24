package app.adapters.invoiceHeaders;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.ports.InvoiceHeaderPort;

@Service
public class InvoiceHeadersAdapter implements InvoiceHeaderPort {

	@Override
	public List<InvoiceHeader> getAllInvoices() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceHeader> getInvoicesByPartner(Partner partner) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<InvoiceHeader> getInvoicesByPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getTotalAmountPayed(Partner partner) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void save(InvoiceHeader invoiceHeader) {
		// TODO Auto-generated method stub
		
	}

}
