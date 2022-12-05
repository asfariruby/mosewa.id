/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.controller;

import co.g2academy.mosewa.model.Car;
import co.g2academy.mosewa.model.Reservation;
import co.g2academy.mosewa.model.User;
import co.g2academy.mosewa.repository.CarRepository;
import co.g2academy.mosewa.repository.ReservationRepository;
import co.g2academy.mosewa.repository.UserRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    
    
//    GET /api/customer will return customer data.
    @GetMapping("/customer")
    public User getUserByUsername(@PathVariable String username) {
        return userRepository.findUserByUsername(username);
    }
//    GET /api/search{CAR_TYPE} to serve search request get all available vehicle 
//    (status available, unreserved, based on type and brand).
//    @GetMapping("/search{type}")
//    private Car getCarByType(@PathVariable String type) {
//        Optional<Car> opt = carRepository.findBy(type, queryFunction);
//        if(String status = "" )
//        return 
//    }

//    POST /api/reserve with json data in response body to reserve car
    @PostMapping("/reserve")
    public ResponseEntity reserve(Principal principal) throws JsonProcessingException {
        User u = userRepository.findUserByUsername(principal.getName());
        Reservation reservation = reservationRepository.findReservationByEmail(u, "RESERVED");
        if(reservation == null){
            return ResponseEntity.badRequest().body("No reservation found");
        }
        
    }
    }
    


