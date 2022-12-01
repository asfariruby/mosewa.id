/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.controller;

import co.g2academy.mosewa.model.Customer;
import co.g2academy.mosewa.repository.CustomerRepository;
import co.g2academy.mosewa.validator.RegexEmailValidator;
import co.g2academy.mosewa.validator.RegexPasswordValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.
/**
 *
 * @author user
 */
import org.springframework.context.annotation.Bean;
@RestController
@RequestMapping("/api")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RegexEmailValidator emailValidator;
    @Autowired
    private RegexPasswordValidator passwordValidator;
    
    private PasswordEncoder passwordEncoder = new BCryp
    
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody Customer customer){
        Customer customerFromDb = customerRepository.findCustomerByUsername(customer.getEmail());
        if (customerFromDb == null
                && emailValidator.emailPatternMatch(customer.getEmail())
                && passwordValidator.passwordPatternMatch(customer.getPassword())) {
            customer.setPassword(password);
        }
    }

}
