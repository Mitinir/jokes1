package com.croz.jokes.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @NotBlank(message = "Category is mandatory")
    @Column(name="name")
    private String name;

    //getters and setters
    public Category(){}

    public Category(long id, String name){
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return name;
    }

}