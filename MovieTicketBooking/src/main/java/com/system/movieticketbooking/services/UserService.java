package com.system.movieticketbooking.services;

import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;

import java.util.List;

public interface UserService {

    User fetchById(Integer id);

    UserPojo saveUser(UserPojo userPojo);

    void deleteById(Integer id);

    User findByEmail(String email);

    List<User> fetchAll();

    String updateResetPassword(String email);

    void processPasswordResetRequest(String email);

    void sendEmail();
}
