package com.system.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "booking")
public class Booking {
    @Id
    @SequenceGenerator(name = "mtb_booking_seq_gen", sequenceName = "mtb_booking_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mtb_booking_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer bookingId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_User_Id"))
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id", referencedColumnName = "Id",
            foreignKey = @ForeignKey(name = "FK_Product_Id"))
    private Movie movie;

    private Date showDate;

    private Time showTime;


    private String queue;

}
