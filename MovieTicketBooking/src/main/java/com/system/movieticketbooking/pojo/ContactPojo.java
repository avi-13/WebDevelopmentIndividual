package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.Contact;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class ContactPojo {
    private Integer contactId;
    private String cName;
    private String cEmail;
    private String cMessage;

    public ContactPojo(Contact contact) {
        this.contactId = contact.getContactId();
        this.cName = contact.getContactName();
        this.cEmail = contact.getContactEmail();
        this.cMessage= contact.getMessage();


    }
}