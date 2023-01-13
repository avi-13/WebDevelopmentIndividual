package com.system.movieticketbooking.pojo;

import com.system.movieticketbooking.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Pojo backend ko validation ko laagi ekdamai important

@Getter
@Setter
@NoArgsConstructor // dynamic banaunw duitai pass gareko
@AllArgsConstructor // dynamic banaunw duitai pass gareko
public class UserPojo {

    private Integer id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String mobileNo;
    private String password;



    // user entity rw yai pojo bich ko data lai matching garauxw
    public UserPojo(User user){
        this.id= user.getId();
        this.firstName = user.getFirstName();
        this.lastName=user.getLastName();
        this.userName=user.getUserName();
        this.email=user.getEmail();
        this.password=user.getPassword();
        this.mobileNo=user.getMobileNo();

    }
//    User Entity ma jun jun variable xw tai rakhney


}
