/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Partner;
import app.domain.models.User;

/**
 *
 * @author ESTUDIANTE
 */
public interface UserPort {
    public boolean existUserName(String userName);

    public void saveUser(Partner partner);

    public User findByPersonId(long personId);
}
