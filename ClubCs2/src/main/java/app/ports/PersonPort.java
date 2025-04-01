/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Person;

/**
 *
 * @author ESTUDIANTE
 */
public interface PersonPort {
    public boolean existPerson(long document);
    public void savePerson(Person person);
    public Person findByDocument(long document);
}
