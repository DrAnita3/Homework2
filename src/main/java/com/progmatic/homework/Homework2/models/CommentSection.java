package com.progmatic.homework.Homework2.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table
public class CommentSection {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Getter
    @Setter
    @Column
    private String commentContent;

    public CommentSection() {
    }

    public CommentSection(int commentId) {
        this.commentId = commentId;
    }

    public CommentSection(int commentId, String commentContent) {
        this.commentId = commentId;
        this.commentContent = commentContent;
    }


    @Override
    public String toString() {
        return commentId + " - " +
                commentContent;
    }

}
