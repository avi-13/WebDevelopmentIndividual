package com.system.movieticketbooking.services;

import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;

import java.util.List;

public interface UserService {

    String saveUser(UserPojo userPojo);

    User findByEmail(String email);

    List<User> fetchAll();
//
//    User findByEmail(Integer id) ;
//
//    void deleteById(Integer id);


}
