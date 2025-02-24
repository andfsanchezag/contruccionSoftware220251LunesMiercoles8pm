package app.domain.models;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class Partner extends User {
	private long partnerId;
	private double amount;
	private String type;
	private Timestamp dateCreated;
    private double totalAmountPayed;
	
	
}
