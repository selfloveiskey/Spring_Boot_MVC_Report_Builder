package com.edmundscodingproject.edmundscodingproject.controller;

import com.edmundscodingproject.edmundscodingproject.Service.FileService;
import com.edmundscodingproject.edmundscodingproject.Service.VehicleService;
import com.edmundscodingproject.edmundscodingproject.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FileController {
    @Autowired
    FileService fileService;

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping("/")
    public String home() {
        return "UploadForm";
    }

    // what is the difference between HttpServletRequest and RequestAttributes
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request) {

        fileService.uploadFile(file);

        request.setAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");

        return "Report";
    }

    @GetMapping("/report")
    public String generateReport() {



        return new String("redirect:/");
    }

//    @PostMapping("/report")
//    public String generateReport(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {
//
//        fileService.uploadFile(file);
//        model.addAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
//        //request.setAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");
//
//        return new uploadFile("redirect:/", model);
//    }
}