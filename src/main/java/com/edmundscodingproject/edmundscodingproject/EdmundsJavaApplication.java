package com.edmundscodingproject.edmundscodingproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*
* Project Objective
* ------------------
* Given a CSV file, write a program that can parse and store Vehicle objects based off of the file.
* A Vehicle has a Year (Integer), Make (String), Model (String) and MSRP(BigDecimal).
* Then, generate a report that details each vehicle grouped by year and ordered by make.
* The report will display the vehicle’s information along with its list price (the list price is the MSRP x Tax Rate(1.07)).
* Save this report to the file system in the same directory as the CSV file.
*/
@SpringBootApplication
public class EdmundsJavaApplication {

    public static void main(String[] args) {

        SpringApplication.run(EdmundsJavaApplication.class, args);
    }

}