/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.repository;

import co.g2academy.mosewa.model.Reservation;
import co.g2academy.mosewa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author user
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer>{
    public Reservation findReservationById(Integer id);
    public Reservation findReservationByEmail(User user, String email);
}
