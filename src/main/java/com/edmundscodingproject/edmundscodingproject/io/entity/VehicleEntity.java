package com.edmundscodingproject.edmundscodingproject.io.entity;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
/*
|----------------------------------------------
| Used to store vehicle details in database
|----------------------------------------------
*/
@Entity
@Table(name="vehicles", schema="edmunds")
public class VehicleEntity {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    private Integer Year;

    @Column(nullable = false, length = 50)
    private String Make;

    @Column(nullable = false, length = 50)
    private String Model;

    @Column(nullable = false)
    private BigDecimal MSRP;

    @Column(nullable = false)
    private BigDecimal listPrice;

    public VehicleEntity(){

    }

    public VehicleEntity(Integer Year, String Make, String Model, BigDecimal MSRP, BigDecimal listPrice){
        this.Year = Year;
        this.Make = Make;
        this.Model = Model;
        this.MSRP = MSRP;
        this.listPrice = listPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getListPrice() {
        return listPrice;
    }

    public void setListPrice(BigDecimal listPrice) {
        this.listPrice = listPrice;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public BigDecimal getMSRP() {
        return MSRP;
    }

    public void setMSRP(BigDecimal MSRP) {
        this.MSRP = MSRP;
    }
}