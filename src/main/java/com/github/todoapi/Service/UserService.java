package com.github.todoapi.Service;

import com.github.todoapi.DTO.UserDTO;
import com.github.todoapi.Entity.User;
import com.github.todoapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(12);

    public UserDTO register(UserDTO reg) {
        User user=new User();
        user.setName(reg.getName());
        user.setEmail(reg.getEmail());
        user.setPassword(encoder.encode(reg.getPassword()));
        User savedUser=userRepository.save(user);
        UserDTO userDTO=new UserDTO();
        userDTO.setName(savedUser.getName());
        userDTO.setEmail(savedUser.getEmail());
        userDTO.setPassword(savedUser.getPassword());
        return userDTO;
    }
}
