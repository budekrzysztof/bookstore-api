package com.kbudek.bookstoreapi.domain;

import java.util.UUID;

public class User {
    private UUID userId;
    private String email;
    private String password;

    public User(UUID userId, String email, String password) {

        this.userId = userId;
        this.email = email;
        this.password = password;

        System.out.println("User {" +
                "\n\tid : " + userId +
                "\n\temail : " + email +
                "\n\tpassword : " + password +
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
