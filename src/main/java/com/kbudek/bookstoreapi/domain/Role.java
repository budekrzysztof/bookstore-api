package com.kbudek.bookstoreapi.domain;

import java.util.UUID;

public class Role {

    private UUID role_id;

    private String name;

    public Role(UUID role_id, String name) {
        this.role_id = role_id;
        this.name = name;
    }

    public UUID getRole_id() {
        return role_id;
    }

    public void setRole_id(UUID role_id) {
        this.role_id = role_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
