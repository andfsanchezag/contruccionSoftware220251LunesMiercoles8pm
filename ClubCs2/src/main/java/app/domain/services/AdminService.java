/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package app.domain.services;

import app.domain.models.InvoiceHeader;
import app.domain.models.Partner;
import app.domain.models.Person;
import app.domain.models.User;
import app.ports.InvoiceHeaderPort;
import app.ports.PartnerPort;
import app.ports.PersonPort;
import app.ports.UserPort;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ESTUDIANTE
 */
@Setter
@Getter
@NoArgsConstructor
@Service
public class AdminService {
   
    @Autowired
    private PersonPort personPort;
    @Autowired
    private UserPort userPort;
    @Autowired
    private PartnerPort partnerPort;
    @Autowired
    private InvoiceHeaderPort invoiceHeaderPort;
    
    public void registerPartner(Partner partner)throws Exception{
        if (personPort.existPerson(partner.getDocument())){
            throw new Exception("ya existe una persona con esa cedula");
        }
        if (userPort.existUserName(partner.getUserName())){
            throw new Exception("ya existe ese username registrado");
        }
        partner.setRole("partner");
        partner.setAmount(50000);
        partner.setType("regular");
        personPort.savePerson(partner);
        userPort.saveUser(partner);
        partnerPort.savePartner(partner);
    }
    
    public List<InvoiceHeader> getInvoiceHeader(Person person)throws Exception{
        if(person==null){
            return invoiceHeaderPort.getAllInvoices();
        }
        person=personPort.findByDocument(person.getDocument());
        if (person==null){
            throw new Exception("no existe una persona con esa cedula");
        }
        User user=userPort.findByPersonId(person);
        if (user==null){
            throw new Exception("no existe un usuario asociado");
        }
        if(user.getRole().equals("partner")){
            Partner partner= partnerPort.findByUserId(user.getUserId());
            if(partner== null){
                throw new Exception("error validando socio");
            }
            return invoiceHeaderPort.getInvoicesByPartner(partner);
        }
        return invoiceHeaderPort.getInvoicesByPerson(person);
    }
    
    public void promotionToVip()throws Exception{
        int countVip = partnerPort.countVip();
        if(countVip>= 5){
            throw new Exception("no hay cupos para VIP");
        }
        List<Partner> partners = partnerPort.getByStatusPending();
        if(partners.isEmpty()){
         throw new Exception("no socios solicitando promocion para VIP");
        }
        for (Partner partner : partners){
            double total = invoiceHeaderPort.getTotalAmountPayed(partner);
            partner.setTotalAmountPayed(total);   
        }
        List<Partner> partnerSorted = partners.stream().sorted(Comparator.comparing(Partner::getTotalAmountPayed)).collect(Collectors.toList());
        for(int i=0; i<partnerSorted.size();i++){
            int newCountVip = partnerPort.countVip();
            if(newCountVip>= 5){
                partnerPort.updateStatusToRegular();
            throw new Exception("no hay mas cupos para VIP");
            }
            partnerPort.updateStatus(partnerSorted.get(i));
        }
    
    }

}
