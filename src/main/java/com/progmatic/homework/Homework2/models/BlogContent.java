package com.progmatic.homework.Homework2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class BlogContent {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int blogContentId;

    @Getter
    @Setter
    @Column(nullable = false)
    private String blogContent;


    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    @Column
    private BlogContentState blogContentState;

    //private List<CommentSection> commentSectionList;

    public BlogContent() {
    }

    public BlogContent(int blogContentId) {
        this.blogContentId = blogContentId;
    }

    public BlogContent(int blogContentId, String blogContent) {
        this.blogContentId = blogContentId;
        this.blogContent = blogContent;
    }

    public BlogContent(int blogContentId, String blogContent, BlogContentState blogContentState) {
        this.blogContentId = blogContentId;
        this.blogContent = blogContent;
        this.blogContentState = blogContentState;
    }



    /*public void setCommentSectionList(List<CommentSection> commentSectionList) {
        this.commentSectionList = commentSectionList;
    }*/

    @Override
    public String toString() {
        return blogContentId + " - " +
                blogContent + ", " ;
                //commentSectionList;
    }
}
