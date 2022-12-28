package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.AboutUs;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AboutUsPojo {
    private Integer Id;
    private String aboutUs;
    private String history;

    public AboutUsPojo(AboutUs aboutUs) {
        this.Id = aboutUs.getId();
        this.aboutUs = aboutUs.getAboutUs();
        this.history = aboutUs.getHistory();
    }
}