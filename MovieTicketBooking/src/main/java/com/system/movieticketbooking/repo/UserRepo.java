package com.system.movieticketbooking.repo;

import com.system.movieticketbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Entity vitrw ko User
@Repository
public interface UserRepo extends JpaRepository< User, Integer> {


}
