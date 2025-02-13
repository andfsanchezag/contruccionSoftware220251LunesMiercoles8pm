package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Person {
	private long personId;
	private long document;
	private String name;
	private long cellPhone;
	
	public Person(long personId, long document, String name, long cellPhone) {
		this.personId = personId;
		this.document = document;
		this.name = name;
		this.cellPhone = cellPhone;
	}
	
	
}
