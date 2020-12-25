package com.poluch.martin.companyApp.service;

import com.poluch.martin.companyApp.entity.Document;
import com.poluch.martin.companyApp.entity.Employee;
import com.poluch.martin.companyApp.entity.Position;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileUploadService {

    List<Document> findAll();

    Document findById(int id);

    void save(MultipartFile file) throws IOException;

    void deleteById(int id);
}
