package com.edmundscodingproject.edmundscodingproject.controller;

import com.edmundscodingproject.edmundscodingproject.Service.FileService;
import com.edmundscodingproject.edmundscodingproject.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
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

    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, HttpServletRequest request, Model model) {

        fileService.uploadFile(file);

        request.setAttribute("message","You successfully uploaded " + file.getOriginalFilename() + "!");

        return "redirect:/";
    }
}