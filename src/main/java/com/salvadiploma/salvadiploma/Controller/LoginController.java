package com.salvadiploma.salvadiploma.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.salvadiploma.salvadiploma.repository.LoginRepository;
import com.salvadiploma.salvadiploma.model.User;
import com.salvadiploma.salvadiploma.model.RegisterRequest;

@RestController
public class LoginController {

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private LoginRepository userRepository;

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public ResponseEntity<User> register(@RequestBody RegisterRequest request) {
        String name = request.getName();
        String password = request.getPassword();

        User user = userRepository.findByName(name);
        
        if (user != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return ResponseEntity.ok(user);
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
    }
}
