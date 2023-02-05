package com.system.movieticketbooking.services.impl;
import com.system.movieticketbooking.entity.User;
import com.system.movieticketbooking.pojo.UserPojo;
import com.system.movieticketbooking.repo.UserRepo;
import com.system.movieticketbooking.services.UserService;
import com.system.movieticketbooking.exception.AppException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
        user.setFullName(userPojo.getFullName());
        user.setUsername(userPojo.getUsername());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobileNo());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(userPojo.getPassword());
        user.setPassword(encodePassword);
        userRepo.save(user);
        return "created";
    }

    @Override
    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
    }

    public List<User> fetchAll() {
        return this.userRepo.findAll();
    }

//    @Override
//    public void deleteById(Integer id) {
//        userRepo.deleteById(id);
//    }
}