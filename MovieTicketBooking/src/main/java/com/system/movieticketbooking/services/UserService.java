package com.system.movieticketbooking.services;

import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;

import java.util.List;

public interface UserService {

    String saveUser(UserPojo userPojo);

    List<User> fetchAll();
//
//    User fetchById(Integer id) ;
//
//    void deleteById(Integer id);


}
