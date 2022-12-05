/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.rent2go.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name = "t_car")
public class Car implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 10, nullable = false)
    private String licensePlate;
    @Column(length = 20, nullable = false)
    private String type;
    @Column(length = 20, nullable = false)
    private String brand;
    @Column(nullable = false)
    private Integer year;
    @Column(length = 10, nullable = false)
    private String transmission;
    @Column(nullable = false)
    private Integer capacity;
    @Column(length = 20, nullable = false)
    private String ownershipCertificateNumber;
    @Column(nullable = false)
    private Integer costPerDay;
    @Column(nullable = false)
    private Integer carLongitude;
    @Column(nullable = false)
    private Integer carLatitude;
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getOwnershipCertificateNumber() {
        return ownershipCertificateNumber;
    }

    public void setOwnershipCertificateNumber(String ownershipCertificateNumber) {
        this.ownershipCertificateNumber = ownershipCertificateNumber;
    }

    public Integer getCostPerDay() {
        return costPerDay;
    }

    public void setCostPerDay(Integer costPerDay) {
        this.costPerDay = costPerDay;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getCarLongitude() {
        return carLongitude;
    }

    public void setCarLongitude(Integer carLongitude) {
        this.carLongitude = carLongitude;
    }

    public Integer getCarLatitude() {
        return carLatitude;
    }

    public void setCarLatitude(Integer carLatitude) {
        this.carLatitude = carLatitude;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
