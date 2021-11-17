package com.progmatic.homework.Homework2.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table
public class UserProfile implements UserDetails {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int userId;

    @Getter
    @Setter
    @Column
    private String username;

    @Getter
    @Setter
    @Column
    private String userPassword;

    @Getter
    @Setter
    @Column
    private String wholeName;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private ProfileType profileType;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private UserAuthority userAuthority;

    @Getter
    @Setter
    @Column
    private byte[] profileImg;

    @Getter
    @Setter
    @Column
    private String emailAddress;


    @Getter
    @Setter
    private boolean isEnabled;


    @Getter
    @Setter
    private boolean isLocked;

    //List<BlogSettings> blogSettings;


    public UserProfile() {
        isEnabled = true;
    }

    public UserProfile(int userId, String username, ProfileType profileType,
                       UserAuthority userAuthority, boolean isEnabled) {
        this.userId = userId;
        this.username = username;
        this.profileType = profileType;
        this.userAuthority = userAuthority;
        isEnabled = true;
    }

    public UserProfile(int userId, String username, String userPassword, String wholeName,
                       ProfileType profileType, UserAuthority userAuthority, String emailAddress) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.wholeName = wholeName;
        this.profileType = profileType;
        this.userAuthority = userAuthority;
        this.emailAddress = emailAddress;
    }

    public UserProfile(int userId, String username, String userPassword, String wholeName, ProfileType profileType,
                       byte[] profileImg, String emailAddress, boolean isEnabled) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.wholeName = wholeName;
        this.profileType = profileType;
        this.profileImg = profileImg;
        this.emailAddress = emailAddress;
        isEnabled = true;
    }


    /*public List<BlogSettings> getBlogSettings() {
        return blogSettings;
    }

    public void setBlogSettings(List<BlogSettings> blogSettings) {
        this.blogSettings = blogSettings;
    }*/

    @Override
    public String toString() {
        return userId + " - " +
                username + ", " +
                userPassword + ", " +
                wholeName + ", " +
                profileType + ", " +
                userAuthority + ", " +
                profileImg + ", " +
                emailAddress + ", ";
                //blogSettings;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(UserAuthority auth : profileType.AUTHORITIES){
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(auth.name());
            list.add(authority);
        }
        return list;
    }


    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !isLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return !isLocked;
    }

    @Override
    public boolean isEnabled() {
        return !isLocked;
    }
}
