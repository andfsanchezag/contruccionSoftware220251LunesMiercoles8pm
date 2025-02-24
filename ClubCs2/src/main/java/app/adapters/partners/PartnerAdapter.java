package app.adapters.partners;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.models.Partner;
import app.ports.PartnerPort;

@Service
public class PartnerAdapter implements PartnerPort {

	@Override
	public void savePartner(Partner partner) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Partner findByUserId(long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countVip() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Partner> getByStatusPending() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateStatusToRegular() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(Partner get) {
		// TODO Auto-generated method stub
		
	}

}
