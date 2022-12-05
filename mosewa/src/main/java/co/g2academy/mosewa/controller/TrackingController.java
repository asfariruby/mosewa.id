/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.controller;

import co.g2academy.mosewa.model.Tracking;
import co.g2academy.mosewa.repository.TrackingRepository;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author user
 */
@Controller
@RequestMapping("/api")
public class TrackingController {
    @Autowired
    private TrackingRepository trackingRepository;
//    POST /api/location  IoT will send current location (lat, lon, current time) to tracking service
    @PostMapping("/location")
    public ResponseEntity update(@RequestBody Tracking tracking, Principal principal) {
        Optional<Tracking> opt
                = trackingRepository.findById(tracking.getId());
        if (!opt.isEmpty()) {
            Tracking trackingFromDb = opt.get();
            if (trackingFromDb.getReservation().getUser()
                    .equals(principal.getName()));
            trackingFromDb.setLatitude(tracking.getLatitude());
            trackingFromDb.setLongitude(tracking.getLongitude());
            trackingFromDb.setTimestamp(tracking.getTimestamp());
            trackingRepository.save(trackingFromDb);
            return ResponseEntity.ok("success");
        }
        return ResponseEntity.badRequest().body("Product not found");
    }
}
