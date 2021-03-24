package com.edmundscodingproject.edmundscodingproject.Service;

import com.edmundscodingproject.edmundscodingproject.io.entity.VehicleEntity;

import java.util.ArrayList;
import java.util.List;

/*
|---------------------------------------------------------------------------------
| Abstract methods detailing what actions you can perform while hiding how the
| actions are performed/implemented
|---------------------------------------------------------------------------------
*/
public interface VehicleService {
    List<VehicleEntity> saveVehicles(List<ArrayList<String>> vehicles, double taxRate);

    List<List<VehicleEntity>> getAllVehicles();
}