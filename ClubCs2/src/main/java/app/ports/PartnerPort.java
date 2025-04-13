/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package app.ports;

import app.domain.models.Partner;
import app.domain.models.User;

import java.util.List;

/**
 *
 * @author ESTUDIANTE
 */
public interface PartnerPort {
    public void savePartner(Partner partner);

    public Partner findByUserId(long userId);

    public int countVip();

    public List<Partner> getByTypePending();

	public Partner findByUserId(User user);

	void updateTypeToRegular();

	void updateType(Partner partner);

}
