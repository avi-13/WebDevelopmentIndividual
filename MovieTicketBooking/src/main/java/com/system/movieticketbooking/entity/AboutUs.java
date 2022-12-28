package com.system.movieticketbooking.entity;



import jakarta.persistence.*;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aboutus")

public class AboutUs {
    @Id
    @SequenceGenerator(name = "shb_product_seq_gen", sequenceName = "shb_product_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "shb_product_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String aboutUs;

    private String history;

}
