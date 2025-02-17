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
public class Guest extends User{
    private long guestId;
    private Partner partner;
    private boolean status;

    public Guest(long guestId, Partner partner, boolean status) {
        this.guestId = guestId;
        this.partner = partner;
        this.status = status;
    }
    
    
}
