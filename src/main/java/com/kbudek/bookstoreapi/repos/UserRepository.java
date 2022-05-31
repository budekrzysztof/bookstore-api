package com.kbudek.bookstoreapi.repos;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;

public interface UserRepository {

    User create(String user_id, String email, String password) throws BSAuthException;

    User findByEmailAndPassword(String email, String password) throws BSAuthException;

    Integer getCountByEmail(String email);

    User findById(Integer user_id);
}
