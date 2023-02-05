package com.system.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @SequenceGenerator(name = "mtb_user_seq_gen", sequenceName = "mtb_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mtb_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name ="movie_name", nullable = false)
    private String movieName;

    @Column(name="description" , nullable = false)
    private String movieDescription;

    @Column(name = "casts" , nullable = false)
    private String cast;

    @Column(name = "director", nullable = false)
    private String director;

    @Column(name = "genre",nullable = false)
    private String genre;

    @Column(name = "release_date",nullable = false)
    private Date releaseDate;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "shows",nullable = false)
    private Integer shows;

    private String image;
    private String imageBase64 ;

}
