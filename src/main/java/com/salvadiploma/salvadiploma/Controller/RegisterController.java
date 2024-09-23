package com.salvadiploma.salvadiploma.Controller;


import com.salvadiploma.salvadiploma.model.RegisterRequest;
import com.salvadiploma.salvadiploma.repository.RegisterRepository;
import com.salvadiploma.salvadiploma.model.User;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.salvadiploma.salvadiploma.service.EmailService;


@RestController
public class RegisterController {
    
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @Autowired
    private RegisterRepository registerRepository;

    @Autowired
    private EmailService emailService; // Injetar o service de e-mail

    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {
        String name = request.getName();
        String email = request.getEmail();
        String password = request.getPassword();
        String level = request.getLevel();
        String image = request.getImage();
        String encryptedPassword = passwordEncoder.encode(password);
    
        User userObject = new User(name, email , encryptedPassword, level, image);
        
        registerRepository.save(userObject);

        String subject = "Confirmação de Registro";
        String text = "Olá " + name + "Seu registro foi efetuado com sucesso! Parabéns por se juntar ao projeto Salva Diploma, Sua contribuição é muito importante para que possamos cumprir com nossa premissa de ajudar os estudantes com suas horas complementares.";
        emailService.sendEmail(email, subject, text);

        return ResponseEntity.ok("Registro efetuado para o usuário: " + name);
        
    }
    
}
