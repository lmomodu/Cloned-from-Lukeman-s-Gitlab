package com.ubuntutech.legalservicies.model.domain;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

/**
 * The Role Entity class
 */
@Entity // This tells Hibernate to make a table out of this class
@Data
@Table(name = "roles")
public class Role {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    // mapping the relationship between users and roles
    @ManyToMany(mappedBy = "roles")
    private List<User> users = new ArrayList<>(); // the associated field between user and role

    public Role() {}

    public Role(@NotNull String name) {
        this.name = name;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
