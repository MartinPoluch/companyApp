package com.poluch.martin.companyApp.controller;

import com.poluch.martin.companyApp.service.FileUploadService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;

@Controller
@RequestMapping("/upload")
public class FileUploadController {

    private FileUploadService fileUploadService;

    public FileUploadController(FileUploadService fileUploadService) {
        this.fileUploadService = fileUploadService;
    }

    @GetMapping
    public String index() {
        return "fileUpload";
    }

    @PostMapping
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        String message = "You successfully uploaded " + file.getOriginalFilename() + "!";
        try {
            fileUploadService.save(file);
        } catch (IOException e) {
            message = "Cannot upload file: " + e.getMessage();
        }
        redirectAttributes.addFlashAttribute("message", message);
        return "redirect:/upload";
    }
}
