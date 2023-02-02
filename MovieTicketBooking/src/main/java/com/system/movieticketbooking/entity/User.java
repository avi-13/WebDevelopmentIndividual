package com.system.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @SequenceGenerator(name = "mtb_user_seq_gen", sequenceName = "mtb_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mtb_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(nullable = false)
    private String password;

}
