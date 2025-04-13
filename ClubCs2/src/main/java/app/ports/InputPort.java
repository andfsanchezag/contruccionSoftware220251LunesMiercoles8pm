package app.ports;

import app.domain.models.User;

public interface InputPort {
	public void menu() throws Exception;
	public void setUser(User user);
}
