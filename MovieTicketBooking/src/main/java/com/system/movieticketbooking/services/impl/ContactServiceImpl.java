package com.system.movieticketbooking.services.impl;


import com.system.movieticketbooking.entity.Contact;
import com.system.movieticketbooking.pojo.ContactPojo;
import com.system.movieticketbooking.repo.ContactRepo;
import com.system.movieticketbooking.services.ContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {
    private final ContactRepo contactRepo;

    @Override
    public String save(ContactPojo contactPojo){
        Contact contact =new Contact();
        if(contactPojo.getContactId()!=null){
            contact.setContactId(contact.getContactId());
        }
        contact.setContactName(contactPojo.getCName());
        contact.setContactEmail(contactPojo.getCEmail());
        contact.setMessage(contactPojo.getCMessage());


        contactRepo.save(contact);
       return "created";
    }

    @Override
    public List<Contact> fetchAll() {
        return this.contactRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        contactRepo.deleteById(id);

    }

//    @Override
//
//    public Contact fetchById(Integer id) {
//        Contact contact= contactRepo.findById(id).orElseThrow(()-> new RuntimeException("Couldnot find"));
//        contact = Contact.builder()
//                .contactId(contact.getContactId())
//                .contactname(contact.getContactname())
//                .contactemail(contact.getContactemail())
//                .contactsubject(contact.getContactsubject())
//                .contactmessage(contact.getContactmessage())
//                .build();
//        return contact;
//    }

}
