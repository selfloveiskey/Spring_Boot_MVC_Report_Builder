package com.edmundscodingproject.edmundscodingproject.repository;

import com.edmundscodingproject.edmundscodingproject.io.entity.VehicleEntity;
import com.edmundscodingproject.edmundscodingproject.model.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
/*
* Using this to access my database
* */
@Repository
public interface VehicleRepository extends CrudRepository<VehicleEntity, Long> {

}