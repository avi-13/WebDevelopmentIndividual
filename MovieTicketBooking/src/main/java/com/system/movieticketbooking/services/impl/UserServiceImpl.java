package com.system.movieticketbooking.services.impl;
import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;
import com.system.movieticketbooking.repo.UserRepo;
import com.system.movieticketbooking.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;


//    @Override
//    public User fetchById(Integer id) {
//        return userRepo.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
//    }

    @Override
    public String saveUser(UserPojo userPojo) {
        User user = new User();
        if (userPojo.getId()!= null){
            user.setId(userPojo.getId());
        }
        user.setFirstName(userPojo.getFirstName());
        user.setLastName(userPojo.getLastName());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobileNo());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }

    public List<User> fetchAll() {
        return this.userRepo.findAll();
    }

//    @Override
//    public void deleteById(Integer id) {
//        userRepo.deleteById(id);
//    }
}