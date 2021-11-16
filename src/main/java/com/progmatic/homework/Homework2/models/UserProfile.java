package com.progmatic.homework.Homework2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class UserProfile {

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
    @Column
    private byte[] profileImg;

    @Getter
    @Setter
    @Column
    private String emailAddress;

    //List<BlogSettings> blogSettings;


    public UserProfile() {
    }

    public UserProfile(int userId, String username, ProfileType profileType) {
        this.userId = userId;
        this.username = username;
        this.profileType = profileType;
    }

    public UserProfile(int userId, String username, String userPassword, String wholeName, ProfileType profileType,
                       byte[] profileImg, String emailAddress) {
        this.userId = userId;
        this.username = username;
        this.userPassword = userPassword;
        this.wholeName = wholeName;
        this.profileType = profileType;
        this.profileImg = profileImg;
        this.emailAddress = emailAddress;
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

}
