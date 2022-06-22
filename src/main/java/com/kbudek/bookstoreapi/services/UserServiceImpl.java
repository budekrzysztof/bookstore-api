package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
import com.kbudek.bookstoreapi.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;
import java.util.regex.Pattern;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User validateUser(String email, String password) throws BSAuthException {
        if(email != null) email = email.toLowerCase();
        return userRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public User registerUser(String email, String password) throws BSAuthException {

        if(email != null) email = email.toLowerCase();
        // compare with email regex
        if(!(Pattern.compile("^(.+)@(.+)$")).matcher(email).matches())
            throw new BSAuthException("Invalid email format");
        // check if password doesn't already exist
        if(userRepository.getCountByEmail(email) > 0)
            throw new BSAuthException("Email address has already been used");
        // return new user with generated UUID and hashed password
        return userRepository.create(UUID.randomUUID(), email, BCrypt.hashpw(password, BCrypt.gensalt(10)));
    }
}
