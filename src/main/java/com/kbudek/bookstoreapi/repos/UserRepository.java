package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;

import java.util.UUID;

public interface UserRepository {

    User create(UUID user_id, String email, String hashedPassword) throws BSAuthException;

    User findByEmailAndPassword(String email, String password) throws BSAuthException;

    Integer getCountByEmail(String email);

    User findById(UUID user_id);
}
