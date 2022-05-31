package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;

public interface UserService {

    User validateUser(String email, String password) throws BSAuthException;

    User registerUser(String id, String email, String password) throws BSAuthException;
}
