package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;

import java.util.UUID;

public interface UserService {

    User validateUser(String email, String password) throws BSAuthException;

    User registerUser(UUID id, String email, String password) throws BSAuthException;
}
