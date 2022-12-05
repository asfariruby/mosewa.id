/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.rent2go.security.service;

import co.g2academy.rent2go.model.User;
import co.g2academy.rent2go.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
//JWTUserDetailsService implements the Spring Security UserDetailsService interface. 
//It overrides the loadUserByUsername for fetching user details from the database using the username. 
//The Spring Security Authentication Manager calls this method for getting the user details from the database when authenticating the user details provided by the user. 
@Service
public class JwtUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.findUserByEmail(username);
        if (user != null) {
            org.springframework.security.core.userdetails.User userDetails =
                    new org.springframework.security.core.userdetails.User(
                    username, user.getPassword(), new ArrayList<>());
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
