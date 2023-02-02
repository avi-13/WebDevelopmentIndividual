package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserPojo {

    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String mobileNo;
    private String password;



    public UserPojo(User user){
        this.id= user.getId();
        this.firstName = user.getFirstName();
        this.lastName=user.getLastName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.mobileNo=user.getMobileNo();
    }


}
