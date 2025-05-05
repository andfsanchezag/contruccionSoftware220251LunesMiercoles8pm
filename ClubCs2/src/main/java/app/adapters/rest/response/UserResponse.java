package app.adapters.rest.response;

public class UserResponse {
	private String name;
	private String userName;
	private long cellphone;
	private String role;
	private long document;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public long getCellphone() {
		return cellphone;
	}
	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	
	
}
