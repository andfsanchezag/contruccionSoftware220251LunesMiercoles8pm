/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author ESTUDIANTES
 */
@Setter
@Getter
@NoArgsConstructor
public class User extends Person{
    private long userId;
    private String userName;
    private String password;
    private String role;

    public User(long userId, String userName, String password, String role, long personId, long document, String name, long cellPhone) {
        super(personId, document, name, cellPhone);
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.role = role;
    }
    
    
}
