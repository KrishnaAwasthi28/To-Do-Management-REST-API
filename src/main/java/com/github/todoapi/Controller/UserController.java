package com.github.todoapi.Controller;

import com.github.todoapi.DTO.UserDTO;
import com.github.todoapi.Entity.User;
import com.github.todoapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    private ResponseEntity<UserDTO> register(@RequestBody UserDTO user){
        return ResponseEntity.ok(userService.register(user));
    }

}
