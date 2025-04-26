package app.adapters.rest.request;

public class GuestRequest {
	private String name;
	private long document;
	private long cellphone;
	private String userName;
	private String password;
	private long partnerDocument;
	
	
	
	@Override
	public String toString() {
		return "GuestRequest [name=" + name + ", document=" + document + ", cellphone=" + cellphone + ", userName="
				+ userName + ", password=" + password + ", partnerDocument=" + partnerDocument + "]";
	}
	public long getPartnerDocument() {
		return partnerDocument;
	}
	public void setPartnerDocument(long partnerDocument) {
		this.partnerDocument = partnerDocument;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public long getCellphone() {
		return cellphone;
	}
	public void setCellphone(long cellphone) {
		this.cellphone = cellphone;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
