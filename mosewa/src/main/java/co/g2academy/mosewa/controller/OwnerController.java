/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.controller;

import co.g2academy.mosewa.model.Car;
import co.g2academy.mosewa.model.Reservation;
import co.g2academy.mosewa.model.Tracking;
import co.g2academy.mosewa.model.User;
import co.g2academy.mosewa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import co.g2academy.mosewa.repository.CarRepository;
import co.g2academy.mosewa.repository.ReservationRepository;
import co.g2academy.mosewa.repository.TrackingRepository;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author user
 */
@RestController
@RequestMapping("/api")
public class OwnerController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TrackingRepository trackingRepository;

//    POST /api/car will register car with type, brand, price, address  data in request body
    @PostMapping("/car")
    public String save(@RequestBody Car car, Principal principal) {
        User u = userRepository.findUserByUsername(principal.getName());
        car.setUser(u);
        carRepository.save(car);
        return "Success";
    }

//    GET /api/car will return all vehicle data owned by owner
    @GetMapping("/car")
    private List<Car> getCar() {
        return carRepository.findAll();
    }

//    GET /api/reservation  will return reservation data from customer. 
    @GetMapping("/reservation")
    private List<Reservation> getReservation(){
        return reservationRepository.findAll();
    }

    
//    PUT /api/car/# update car data with id of # and data in request body (+status)
    @PutMapping("/car/{id}")
    public ResponseEntity updateCarData(@RequestBody Car car, Principal principal) {
            Optional<Car> opt
                    = carRepository.findById(car.getId());
            if (!opt.isEmpty()) {
                Car carFromDb = opt.get();
                if (carFromDb.getUser().getEmail()
                        .equals(principal.getName()));
                carFromDb.setLicensePlate(car.getLicensePlate());
                carFromDb.setType(car.getType());
                carFromDb.setBrand(car.getBrand());
                carFromDb.setTransmission(car.getTransmission());
                carFromDb.setCapacity(car.getCapacity());
                carFromDb.setCostPerDay(car.getCostPerDay());

                carRepository.save(carFromDb);
                return ResponseEntity.ok("success");
            }
            return ResponseEntity.badRequest().body("Reservation not found");
    }
    
//    GET /api/car-monitoring  will return car location data. 
    @GetMapping("/car-monitoring")
    private List<Tracking> getTracking() {
        return trackingRepository.findAll();
    }
}
