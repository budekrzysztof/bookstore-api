package com.kbudek.bookstoreapi.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@RestController
@RequestMapping("/api/categories")
public class CategoryResource {
    @GetMapping("")
    public String getAllCategories(HttpServletRequest request) {
        UUID user_id = (UUID) UUID.fromString((String) request.getAttribute("user_id"));
        return "Authenticated! User id: " + user_id;
    }
}
