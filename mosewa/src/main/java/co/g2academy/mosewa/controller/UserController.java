/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.controller;

import co.g2academy.mosewa.model.Customer;
import co.g2academy.mosewa.model.User;
import co.g2academy.mosewa.validator.RegexEmailValidator;
import co.g2academy.mosewa.validator.RegexPasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.g2academy.mosewa.repository.UserRepository;
/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RegexEmailValidator emailValidator;
    @Autowired
    private RegexPasswordValidator passwordValidator;
    
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        User userFromDb = userRepository.findUserByUsername(user.getEmail());
        if (userFromDb == null
                && emailValidator.emailPatternMatch(user.getEmail())
                && passwordValidator.passwordPatternMatch(user.getPassword())) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
        }else {
            return ResponseEntity.badRequest().body("email or password invalid");
        }
        return ResponseEntity.ok().body("OK");
    }
}
