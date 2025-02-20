/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Person;
import app.domain.models.User;

/**
 *
 * @author ESTUDIANTE
 */
public interface UserPort {
    public boolean existUserName(String userName);

    public void saveUser(User user);

    public User findByPersonId(Person person);
}
