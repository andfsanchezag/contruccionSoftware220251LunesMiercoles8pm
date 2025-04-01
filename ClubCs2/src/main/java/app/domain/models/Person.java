package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class Person {
	private long personId;
	private long document;
	private String name;
	private long cellPhone;
	public long getPersonId() {
		return personId;
	}
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	public long getDocument() {
		return document;
	}
	public void setDocument(long document) {
		this.document = document;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(long cellPhone) {
		this.cellPhone = cellPhone;
	}
	
	
	
}
