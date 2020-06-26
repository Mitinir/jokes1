package com.croz.jokes.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="jokes")
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotBlank(message = "Joke is mandatory")
    @Column(name="content")
    private String content;

    @Column(name="likes")
    private int likes;

    @Column(name="dislikes")
    private int dislikes;

    @ManyToOne
    @JoinColumn(name="category")
    private Category category;

    //getters and setters
    public Joke(){}

    public Joke(String content, int likes, int dislikes){
        this.content = content;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public Category getCategory() {
        return category;
    }
}
