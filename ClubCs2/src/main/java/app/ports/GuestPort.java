package app.ports;

import app.domain.models.Guest;
import app.domain.models.User;

public interface GuestPort {
	public Guest findByUserId(User userId);
	public void save(Guest guest);
}
