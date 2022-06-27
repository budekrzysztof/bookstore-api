package com.kbudek.bookstoreapi.domain;

import com.kbudek.bookstoreapi.services.RoleService;
import com.kbudek.bookstoreapi.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class User {
    private UUID userId;
    private String email;
    private String password;
    private Set<Role> roles;

    public User(UUID userId, String email, String password) {

        RoleService roleService = new RoleServiceImpl();

        this.userId = userId;
        this.email = email;
        this.password = password;
        this.roles = roleService.getUserRoles(userId);

        System.out.println("User {" +
                "\n\tid : " + userId +
                "\n\temail : " + email +
                "\n\tpassword : " + password +
                "\n\troles : " + roles.toString() +
                "\n}");
    }

    public UUID getUserId() {
        return this.userId;
    }

    public void setUserId(UUID userId) {
        this.userId = this.userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
