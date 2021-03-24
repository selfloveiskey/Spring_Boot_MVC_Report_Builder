package com.edmundscodingproject.edmundscodingproject.ServiceImpl;

import com.edmundscodingproject.edmundscodingproject.Service.VehicleService;
import com.edmundscodingproject.edmundscodingproject.io.entity.VehicleEntity;
import com.edmundscodingproject.edmundscodingproject.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/*
|--------------------------------------------------------------------------
| Details how the abstract methods from VehicleService are implemented
|--------------------------------------------------------------------------
*/
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    VehicleRepository vehicleRepository;

    @Override
    public List<VehicleEntity> saveVehicles(List<ArrayList<String>> vehicleRecords, double taxRate) {

        // Make sure you aren't saving existing data more than once
        //List<VehicleEntity> duplicateRecordCheck = (List<VehicleEntity>) vehicleRepository.findAll();

        for (List<String> vehicle : vehicleRecords) {
            VehicleEntity vehicleEntity = new VehicleEntity();
            vehicleEntity.setYear(Integer.valueOf(vehicle.get(0)));
            vehicleEntity.setMake(vehicle.get(1));
            vehicleEntity.setModel(vehicle.get(2));
            vehicleEntity.setMSRP(BigDecimal.valueOf(Integer.valueOf(vehicle.get(3))));

            BigDecimal MSRP = vehicleEntity.getMSRP();
            BigDecimal listPrice = new BigDecimal(taxRate).multiply(MSRP);
            vehicleEntity.setListPrice(listPrice);

            vehicleRepository.save(vehicleEntity);
        }

        List<VehicleEntity> savedVehicleEntity = (List<VehicleEntity>) vehicleRepository.findAll();

        // check if null
        if(savedVehicleEntity.isEmpty()){
            System.out.println("No results were found in the database.");
        }

        return savedVehicleEntity;
    }

    @Override
    public List<List<VehicleEntity>> getAllVehicles() {
        return null;
    }
}