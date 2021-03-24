package com.edmundscodingproject.edmundscodingproject.dto;

import java.math.BigDecimal;
/*
|----------------------------------------------------------------------------------------------------
| Dto = Data Transfer Object
| Aggregate and encapsulate data for transfer
| Used to serve related information together to avoid multiple calls for each piece of information
|----------------------------------------------------------------------------------------------------
*/
public class VehicleDto {

    private long id;
    private Integer Year;
    private String Make;
    private String Model;
    private BigDecimal MSRP;
    private float taxRate;

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

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }
}