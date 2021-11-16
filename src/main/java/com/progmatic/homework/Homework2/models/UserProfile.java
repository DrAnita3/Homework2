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
    private Long userId;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String userPassword;

    @Getter
    @Setter
    @Column(nullable = false)
    private String wholeName;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private ProfileType profileType;

    @Getter
    @Setter
    @Column
    private byte[] profileImg;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String emailAddress;

    //List<BlogSettings> blogSettings;

    private boolean isEnabled;

    public UserProfile(boolean isEnabled) {
        isEnabled = true;
    }

    public UserProfile() {
    }

    public UserProfile(Long userId, String username, ProfileType profileType, boolean isEnabled) {
        this.userId = userId;
        this.username = username;
        this.profileType = profileType;
        isEnabled = true;
    }

    public UserProfile(Long userId, String username, String userPassword, String wholeName, ProfileType profileType,
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
                profileImg + ", " +
                emailAddress + ", ";
                //blogSettings;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(UserAuthority auth : profileType.AUTHORITIES) {
            SimpleGrantedAuthority authority = new SimpleGrantedAuthority(auth.name());
            list.add(authority);
        }
        return list;
    }

    @Override
    public String getPassword() {
        return userPassword;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isEnabled;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isEnabled;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isEnabled;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
