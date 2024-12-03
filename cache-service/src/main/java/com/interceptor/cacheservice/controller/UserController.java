package com.interceptor.cacheservice.controller;

import com.interceptor.cacheservice.model.User;
import com.interceptor.cacheservice.service.UserRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserRestService userRestService;

    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userRestService.getAllUsers());
    }

    @GetMapping
    public ResponseEntity<?> getUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String username) {
        if (id != null) {
            return ResponseEntity.ok(userRestService.getUserById(id));
        } else if (username != null) {
            return ResponseEntity.ok(userRestService.getUserByUsername(username));
        } else {
            return ResponseEntity.badRequest().body("Either 'id' or 'username' must be provided");
        }
    }

    @GetMapping("actual")
    public ResponseEntity<?> getActualUser(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String username) {
        if (id != null) {
            return ResponseEntity.ok(userRestService.getActualUserById(id));
        } else if (username != null) {
            return ResponseEntity.ok(userRestService.getActualUserByUsername(username));
        } else {
            return ResponseEntity.badRequest().body("Either 'id' or 'username' must be provided");
        }
    }
}
