package com.system.movieticketbooking.services;


import com.system.movieticketbooking.entity.AboutUs;
import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.AboutUsPojo;

import java.util.List;

public interface AboutUsService {
    String save(AboutUsPojo aboutUsPojo);

    List<AboutUs> fetchAll();

    Movie fetchById(Integer id);

}
