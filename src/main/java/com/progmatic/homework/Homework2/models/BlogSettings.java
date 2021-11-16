package com.progmatic.homework.Homework2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class BlogSettings {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int blogTypeId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String blogName;

    @Getter
    @Setter
    @Column(nullable = false)
    private String blogCategory;

    @Getter
    @Setter
    @Column(nullable = false)
    private String blogColor;

    @Getter
    @Setter
    @Column(nullable = false)
    private byte[] blogBackground;

    //private List<BlogContent> blogContentList;

    public BlogSettings() {
    }


    public BlogSettings(int blogTypeId, String blogName) {
        this.blogTypeId = blogTypeId;
        this.blogName = blogName;
    }

    public BlogSettings(int blogTypeId, String blogName, String blogCategory, String blogColor, byte[] blogBackground) {
        this.blogTypeId = blogTypeId;
        this.blogName = blogName;
        this.blogCategory = blogCategory;
        this.blogColor = blogColor;
        this.blogBackground = blogBackground;
    }



    /*public List<BlogContent> getBlogContentList() {
        return blogContentList;
    }

    public void setBlogContentList(List<BlogContent> blogContentList) {
        this.blogContentList = blogContentList;
    }*/

    @Override
    public String toString() {
        return blogTypeId + " - " +
                blogName + ", " ;
                //blogContentList;
    }
}
