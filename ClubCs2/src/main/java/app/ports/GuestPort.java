package app.ports;

import java.util.List;

import app.domain.models.Guest;
import app.domain.models.Partner;
import app.domain.models.User;

public interface GuestPort {
	public Guest findByUserId(User userId);
	public void save(Guest guest);
	public List<Guest> findByPartnerIdAndStatusActive(Partner partner);
}
