package com.ubuntutech.legalservicies.model.domain;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
/**
 * The User Entity class
 */

@Data
@Entity // This tells Hibernate to make a table out of this class
@Table(name = "users")
public class User {

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    private  Long id;
    @NotNull
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;
    // mapping the relationship between users and roles
    @ManyToMany
    @JoinColumn@JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "users_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "roles_id", referencedColumnName = "id")
    )

    private List<Role> roles = new ArrayList<>(); // the associated field between user and role

    public User() {
    }

    public User(@NotNull String username, @NotNull String password, @NotNull String email) {
        this.username = username;
        this.password = password;
        this.email=email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}