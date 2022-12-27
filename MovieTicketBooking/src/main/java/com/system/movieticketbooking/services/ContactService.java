package com.system.movieticketbooking.services;



import com.system.movieticketbooking.entity.Contact;
import com.system.movieticketbooking.pojo.ContactPojo;

import java.util.List;

public interface ContactService {
    String save(ContactPojo contactPojo);

    List<Contact> fetchAll();

    void deleteById(Integer id);
}
