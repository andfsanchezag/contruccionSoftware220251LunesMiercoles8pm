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
@NoArgsConstructor
@Setter
@Getter
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
