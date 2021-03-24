package com.edmundscodingproject.edmundscodingproject.Service;

import com.edmundscodingproject.edmundscodingproject.exceptions.FileStorageException;
import com.edmundscodingproject.edmundscodingproject.io.read.readFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileService {

    @Autowired
    VehicleService vehicleService;

    @Value("${app.upload.dir:${user.home}}")
    public String uploadDir;

    public void uploadFile(MultipartFile file) {

        try {
            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));

            // Copy file to the target location (Replacing existing file with the same name)
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);

            String importedFileName = copyLocation.toString();

            // Error checking
            System.out.println("Path = " + copyLocation);

            // check if file exists and file permissions
            Boolean exists = Files.exists(copyLocation);
            Boolean notExist = Files.notExists(copyLocation);
            Boolean isReadable = Files.isReadable(copyLocation);
            Boolean isDirectory = Files.isDirectory(copyLocation);

            if(exists && isReadable){
                List<ArrayList<String>> vehicles = readFile.readImportedFile(importedFileName);

                // Error checking
                for (List array : vehicles) {
                    System.out.println(array);
                }

                double taxRate = 1.07;
                vehicleService.saveVehicles(vehicles, taxRate);
            } else if (isDirectory) {
                System.out.println("File is a Directory");
            } else if (notExist) {
                System.out.println("File doesn't exist!!");
            } else {
                System.out.println("Program doesn't have access to the file!!");
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw new FileStorageException("Could not store file " + file.getOriginalFilename() + ". Please try again!");
        }
    }
}