/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.domain.models;

import java.sql.Timestamp;
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
public class Partner extends User{
    private long partnerId;
    private double founds;
    private String type;
    private Timestamp createeDate;

    public Partner(long partnerId, double founds, String type, Timestamp createeDate, long userId, String userName, String password, String role, long personId, long document, String name, long cellPhone) {
        super(userId, userName, password, role, personId, document, name, cellPhone);
        this.partnerId = partnerId;
        this.founds = founds;
        this.type = type;
        this.createeDate = createeDate;
    }
    
    
}
