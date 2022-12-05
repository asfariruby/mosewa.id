/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.g2academy.rent2go.mapper;

import co.g2academy.rent2go.model.Car;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 *
 * @author user
 */
public class CarRowMapper implements RowMapper<Car> {
    @Override
    public Car mapRow(ResultSet rs, int rowNum) throws SQLException{
        Car c = new Car();
        c.setId(rs.getInt("id"));
        c.setLicensePlate(rs.getString("license_plate"));
        c.setType(rs.getString("type"));
        c.setBrand(rs.getString("brand"));
        c.setYear(rs.getInt("year"));
        c.setTransmission(rs.getString("transmission"));
        c.setOwnershipCertificateNumber(rs.getString("ownership_certtificate_number"));
        c.setCostPerDay(rs.getInt("cost_per_day"));
        return c;
    }
}
