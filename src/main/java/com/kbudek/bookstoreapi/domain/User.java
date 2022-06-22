package com.kbudek.bookstoreapi.domain;

import com.kbudek.bookstoreapi.services.RoleService;
import com.kbudek.bookstoreapi.services.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Set;
import java.util.UUID;

public class User {
    private UUID user_id;
    private String email;
    private String password;
    private Set<Role> roles;

    public User(UUID user_id, String email, String password) {

        RoleService roleService = new RoleServiceImpl();

        this.user_id = user_id;
        this.email = email;
        this.password = password;
        this.roles = roleService.getUserRoles(user_id);

        System.out.println("User {" +
                "\n\tid : " + user_id +
                "\n\temail : " + email +
                "\n\tpassword : " + password +
                "\n\troles : " + roles.toString() +
                "\n}");
    }

    public UUID getUser_id() {
        return user_id;
    }

    public void setUser_id(UUID user_id) {
        this.user_id = user_id;
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
