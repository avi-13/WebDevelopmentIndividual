package com.system.movieticketbooking;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.repo.MovieRepo;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MovieRepoTest {


    @Autowired
    private MovieRepo movieRepo;

    @Test
    @Order(1)
    @Rollback(value = false)
    public void saveMovie() {

        Movie movie = Movie.builder()
                .movieName("Name")
                .director("director")
                .duration("245 min")
                .image("inm.jpg")
                .genre("horror")
                .build();
//
        movieRepo.save(movie);
        Assertions.assertThat(movie.getId()).isGreaterThan(0);

    }

    @Test
    @Order(2)
    @Rollback(value = false)
    public void getMovieTest() {
        Movie movie = movieRepo.findById(1).get();
        Assertions.assertThat(movie.getId()).isEqualTo(1);
    }

    //
    @Test
    @Order(3)
    public void fetchAll() {
        List<Movie> movie = movieRepo.findAll();
        Assertions.assertThat(movie.size()).isGreaterThan(0);
    }
    //
    @Test
    @Order(4)
    @Rollback(value = false)
    public void Update() {
        Movie movie = movieRepo.findById(1).get();
        movie.setMovieName("Abishek");
        Movie movie1 = movieRepo.save(movie);
        Assertions.assertThat(movie1.getMovieName()).isEqualTo("Abishek");
    }
    //
//    @Test
//    @Test
//    @Order(5)
//    @Rollback(value = false)
//    public void Delete(){
//        Movie user=movieRepo.findById(1).get();
//        movieRepo.delete(user);
//        Movie movie1=null;
//        Optional<Movie> movieOptional=movieRepo.findById(1);
//        if(movieOptional.isPresent()){
//            movie1 = movieOptional.get();
//        }
//        Movie movie2=movieRepo.save(movie1);
//        Assertions.assertThat(movie1).isNull();
//    }
//
//

}