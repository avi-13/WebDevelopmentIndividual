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
    private String fullName;
    private String email;
    private String username;
    private String mobileNo;
    private String password;



    public UserPojo(User user){
        this.id= user.getId();
        this.fullName = user.getFullName();
        this.email=user.getEmail();
        this.username=getUsername();
        this.password=user.getPassword();
        this.mobileNo=user.getMobileNo();
    }


}
