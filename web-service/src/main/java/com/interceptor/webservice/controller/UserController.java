package com.interceptor.webservice.controller;

import com.interceptor.webservice.model.User;
import com.interceptor.webservice.service.UserService;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("all")
    public ResponseEntity<?> getAll() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping()
    public ResponseEntity<?> getByNameOrUsername(
            @PathParam("id") Long id,
            @PathParam("username") String username) {
        User user = id != null ? userService.getById(id) : userService.getByUsername(username);

        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
    }

    @PatchMapping("{id}/status/{status}")
    public ResponseEntity<?> setActiveStatus(
            @PathVariable("id") Long id,
            @PathVariable("status") Boolean status) {
        userService.setActiveStatus(id, status);
        return ResponseEntity.ok().build();
    }


}
