package com.system.movieticketbooking.services.impl;

import com.system.movieticketbooking.entity.Movie;
import com.system.movieticketbooking.pojo.MoviePojo;
import com.system.movieticketbooking.repo.MovieRepo;
import com.system.movieticketbooking.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepo movieRepo;
    public static String UPLOAD_DIRECTORY = System.getProperty("user.dir") + "/images";

    @Override
    public MoviePojo saveMovie(MoviePojo moviePojo) throws IOException {
        Movie movie = new Movie();
        if (moviePojo.getMovieId() != null){
            movie.setId(moviePojo.getMovieId());
        }
        movie.setMovieName(moviePojo.getMovieName());
        movie.setMovieDescription(moviePojo.getMovieDescription());
        movie.setCast(moviePojo.getCast());
        movie.setDirector(moviePojo.getDirector());
        movie.setDuration(moviePojo.getDuration());
        movie.setReleaseDate(moviePojo.getReleaseDate());
        movie.setGenre(moviePojo.getGenre());
        movie.setCategory(moviePojo.getCategory());
        movie.setShows(moviePojo.getShows());

        if(moviePojo.getImage()!=null && moviePojo.getImage1()!=null){
            StringBuilder fileNames = new StringBuilder();
            Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, moviePojo.getImage().getOriginalFilename());
            fileNames.append(moviePojo.getImage().getOriginalFilename());
            Files.write(fileNameAndPath, moviePojo.getImage().getBytes());
            movie.setImage(moviePojo.getImage().getOriginalFilename());

            StringBuilder fileNames1 = new StringBuilder();
            Path fileNameAndPath1 = Paths.get(UPLOAD_DIRECTORY, moviePojo.getImage1().getOriginalFilename());
            fileNames1.append(moviePojo.getImage1().getOriginalFilename());
            Files.write(fileNameAndPath1, moviePojo.getImage1().getBytes());
            movie.setImage1(moviePojo.getImage1().getOriginalFilename());
        }
        movieRepo.save(movie);
        return new MoviePojo(movie);
    }

    @Override
        public Movie fetchById(Integer id) {
            Movie movie = movieRepo.findById(id).orElseThrow(()-> new RuntimeException("Could Not Find"));
            movie = Movie.builder()
                    .id(movie.getId())
                    .movieName(movie.getMovieName())
                    .movieDescription(movie.getMovieDescription())
                    .genre(movie.getGenre())
                .cast(movie.getCast())
                .director(movie.getDirector())
                .category(movie.getCategory())
                .duration(movie.getDuration())
                .releaseDate(movie.getReleaseDate())
                .shows(movie.getShows())
                .imageBase64(getImageBase64(movie.getImage()))
                .image1Base64(getImageBase64(movie.getImage1()))
                .build();
        return movie;
    }

    @Override
    public List<Movie> fetchAll() {
        List<Movie> movie= movieRepo.findAll();
        System.out.println(movie);
         return movie;
    }

    @Override
    public void deleteById(Integer id) {
        movieRepo.deleteById(id);
    }

    public String getImageBase64(String fileName) {
        String filePath = System.getProperty("user.dir") + "/images/";
        File file = new File(filePath + fileName);
        byte[] bytes;
        try {
            bytes = Files.readAllBytes(file.toPath());
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return Base64.getEncoder().encodeToString(bytes);
    }
}
