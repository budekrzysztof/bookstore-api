package com.kbudek.bookstoreapi.services;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.exceptions.BSAuthException;
import com.kbudek.bookstoreapi.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.channels.InterruptedByTimeoutException;
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
    public User registerUser(String user_id, String email, String password) throws BSAuthException {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        if(email != null) email = email.toLowerCase();
        if(!pattern.matcher(email).matches())
            throw new BSAuthException("Invalid email format");
        System.out.println("Right before getcountbt");
        Integer count = userRepository.getCountByEmail(email);
        if(count > 0)
            throw new BSAuthException("Email address  already exists");
        System.out.println("Right before finishing");
        return userRepository.create(user_id, email, password);
    }
}
