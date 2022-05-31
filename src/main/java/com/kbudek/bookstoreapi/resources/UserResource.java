package com.kbudek.bookstoreapi.resources;

import com.kbudek.bookstoreapi.domain.User;
import com.kbudek.bookstoreapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/bookstore")
public class UserResource {

    @Autowired
    UserService userService;

    @PostMapping("/register")
    public ResponseEntity<Map<String, String>> registerUser(@RequestBody Map<String, Object> userMap) {
        System.out.println("Opened register\n");

        String user_id = (String) userMap.get("user_id");
        String email = (String) userMap.get("email");
        String password = (String) userMap.get("password");

        System.out.println("Right before registering. {" + user_id + ", " + email + ", " + password);
        User user = userService.registerUser(user_id, email, password);
        System.out.println("Right after registering");
        Map<String, String> map = new HashMap<>();
        map.put("message", "registered successfully");
        System.out.println("Returning success\n");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
