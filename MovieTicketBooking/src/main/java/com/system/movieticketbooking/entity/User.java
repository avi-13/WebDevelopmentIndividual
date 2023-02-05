package com.system.movieticketbooking.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements UserDetails {
    @Id
    @SequenceGenerator(name = "mtb_user_seq_gen", sequenceName = "mtb_user_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "mtb_user_seq_gen", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name="full_name", nullable = false)
    private String fullName;


    @Column(name = "Email",nullable = false)
    private String email;

    @Column(name = "username",nullable = false)
    private String username;

    @Column(name = "mobile_no")
    private String mobileNo;

    @Column(nullable = false)
    private String password;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return this.email;
    }


    @Override
    public boolean isAccountNonExpired() {
        return true;
    }


    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
