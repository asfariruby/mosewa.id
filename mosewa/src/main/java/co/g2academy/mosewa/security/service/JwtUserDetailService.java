/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.security.service;

import co.g2academy.mosewa.repository.UserRepository;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import static org.springframework.data.redis.serializer.RedisSerializationContext.java;
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
        User user = repository.findUserByUsername(username);
        if (user != null) {
            org.springframework.security.core.userdetails.User userDetails =
                    new org.springframework.security.core.userdetails.User(
                    username, user.getPassword(), new ArrayList<>());
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found");
    }
}
