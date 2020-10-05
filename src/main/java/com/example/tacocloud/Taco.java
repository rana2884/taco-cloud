package com.example.tacocloud;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message="Name must be at least 5 characters long")
    private String taco_name;

    @ManyToMany(targetEntity = Ingredient.class)
    @Size(min=1, message="You have to choose at least one ingredient")
    private List<Ingredient> ingredients = new ArrayList<>();

    @PrePersist
    void createdAt(){
        this.createdAt = new Date();
    }
}
