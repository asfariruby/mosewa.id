/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.service;

import co.g2academy.mosewa.model.Reservation;
import co.g2academy.mosewa.repository.ReservationRepository;
import co.g2academy.mosewa.repository.TrackingRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author user
 */
@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private TrackingRepository trackingRepository;
    @Autowired
    private MessagePublisherService messagePublisherService;

    private ObjectMapper mapper = new JsonMapper();
    @Transactional(readOnly = false)
    public void reserve (Reservation reservation) throws JsonProcessingException{
        //update reservation status
        reservation.setReservationStatus("RESERVED");
        reservation.setReservedDate(new Timestamp(0, 0, 0, 0, 0, 0, 0));
        reservationRepository.save(reservation);
        
        // insert reservation data
        Reservation reservationData = new Reservation();
        reservationData.setReservationStatus("RESERVED");
        reservationData.setUser(reservation.getUser());
        reservationData.setReservedDate(reservation.getReservedDate());
        Integer totalPrice = 0;
        List<Reservation> reservations = new ArrayList<>();
    }
}
