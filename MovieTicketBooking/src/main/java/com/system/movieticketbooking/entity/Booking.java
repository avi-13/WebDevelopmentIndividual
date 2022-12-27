package com.system.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalTime;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @SequenceGenerator(name = "mtb_user_seq_gen", sequenceName = "mtb_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mtb_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer bId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_User_Id"))
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_Product_Id"))
    private Movie movieId;

    private Date showDate;

    private Integer Ticket;

    private LocalTime showTime;

    private String queue;

}
