package app.adapters.persons.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "person")
public class PersonEntity {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long personId;
	@Column(name = "document")
	private long document;
	@Column(name = "name")
	private String name;
	@Column(name = "cell_phone")
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
