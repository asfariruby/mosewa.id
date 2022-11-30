/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.mosewa.model;

import java.io.Serializable;
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
@Table(name = "t_payment")
public class Payment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = true)
    private Integer penaltyCost;
    @Column(nullable = true)
    private Integer damageCompensationCost;
    @Column(nullable = true)
    private Integer additionalDriverCost;
    @Column(nullable = false)
    private Integer totalCost;
    @Column(length = 10, nullable = false)
    private String paymentMethod;
    @OneToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer Customer;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPenaltyCost() {
        return penaltyCost;
    }

    public void setPenaltyCost(Integer penaltyCost) {
        this.penaltyCost = penaltyCost;
    }

    public Integer getDamageCompensationCost() {
        return damageCompensationCost;
    }

    public void setDamageCompensationCost(Integer damageCompensationCost) {
        this.damageCompensationCost = damageCompensationCost;
    }

    public Integer getAdditionalDriverCost() {
        return additionalDriverCost;
    }

    public void setAdditionalDriverCost(Integer additionalDriverCost) {
        this.additionalDriverCost = additionalDriverCost;
    }

    public Integer getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Integer totalCost) {
        this.totalCost = totalCost;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer Customer) {
        this.Customer = Customer;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

}
