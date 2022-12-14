/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import static org.springframework.data.redis.serializer.RedisSerializationContext.java;

/**
 *
 * @author user
 */
@Entity
@Table(name = "t_reservation")
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private Integer duration;
    @Column(length = 100, nullable = false)
    private String destination;
    @Column(length = 255, nullable = false)
    private String rentalAddress;
    @Column(nullable = false)
    private Boolean additionalDriver;
    @Column(nullable = false)
    private Boolean availability;
    @Column(length = 10, nullable = false)
    private String reservationStatus;
    @Column(nullable = false)
    private Timestamp reservedDate;
    @Column(nullable = false)
    private Timestamp transactionDate;
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRentalAddress() {
        return rentalAddress;
    }

    public void setRentalAddress(String rentalAddress) {
        this.rentalAddress = rentalAddress;
    }

    public Boolean getAdditionalDriver() {
        return additionalDriver;
    }

    public void setAdditionalDriver(Boolean additionalDriver) {
        this.additionalDriver = additionalDriver;
    }

    public String getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(String reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Timestamp getReservedDate() {
        return reservedDate;
    }

    public void setReservedDate(Timestamp reservedDate) {
        this.reservedDate = reservedDate;
    }

    public Timestamp getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Timestamp transactionDate) {
        this.transactionDate = transactionDate;
    }

}
