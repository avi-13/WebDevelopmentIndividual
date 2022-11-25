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

    @Column(name = "movie_name")
    private String movieName;

    @Column(name = "description")
    private String movieDescription;

    @Column(name = "casts")
    private String cast;

    @Column(name = "director")
    private String director;

    @Column(name = "genre")
    private String genre;

    @Column(name = "release_date")
    private Date releaseDate;

    @Column(name = "duration")
    private String duration;

    @Column(name = "cube")
    private String cubes;

    @Column(name = "shows")
    private Integer shows;

    private String image;

    private String image1;

    @Transient
    private String imageBase64;

    @Transient
    private String image1Base64;

}
