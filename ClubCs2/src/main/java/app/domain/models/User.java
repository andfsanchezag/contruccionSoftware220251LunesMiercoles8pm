package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class User extends Person {
	private long userId;
	private String userName;
	private String password;
	private String role;
		
	
}
