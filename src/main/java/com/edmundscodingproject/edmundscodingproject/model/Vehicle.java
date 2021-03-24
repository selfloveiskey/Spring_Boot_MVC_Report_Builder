package com.edmundscodingproject.edmundscodingproject.model;

import java.math.BigDecimal;
/*
|----------------------------------------------------------------------------------------------------
| Model encapsulates the application data and consists of POJO which is Plain Old Java Object (POJO)
|----------------------------------------------------------------------------------------------------
*/
public class Vehicle {

    private long id;
    private Integer Year;
    private String Make;
    private String Model;
    private BigDecimal MSRP;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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