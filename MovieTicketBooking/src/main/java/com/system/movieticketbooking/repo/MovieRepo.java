package com.system.movieticketbooking.repo;

import com.system.movieticketbooking.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepo extends JpaRepository <Movie ,Integer>{
}
