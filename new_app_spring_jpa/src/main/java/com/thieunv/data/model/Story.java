package com.thieunv.data.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by thieunv on 05/06/2017.
 */
@Entity
@Table(name = "story")
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="story_id")
    private int storyId;

    @NotNull
    @Column(name="statement",nullable = false)
    private String statement;

    @NotNull
    @Column(name="title",nullable = false)
    private String title;

    @NotNull
    @Column(name="content",nullable = false)
    private String content;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "updated_at")
    private Date updatedAt;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "created_at")
    private Date createdAt;

    @OneToOne
    @JoinColumn(name="category_id")
    private StoryCategory storyCategory;

    public Story() {
    }

    public Story(int storyId) {
        this.storyId = storyId;
    }

    public Story(String statement, String title, String content) {
        this.statement = statement;
        this.title = title;
        this.content = content;
    }

    public int getStoryId() {
        return storyId;
    }

    public void setStoryId(int storyId) {
        this.storyId = storyId;
    }

    public String getStatement() {
        return statement;
    }

    public void setStatement(String statement) {
        this.statement = statement;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public StoryCategory getStoryCategory() {
        return storyCategory;
    }

    public void setStoryCategory(StoryCategory storyCategory) {
        this.storyCategory = storyCategory;
    }
}
