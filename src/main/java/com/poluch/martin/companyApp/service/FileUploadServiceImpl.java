package com.poluch.martin.companyApp.service;

import com.poluch.martin.companyApp.dao.DocumentRepository;
import com.poluch.martin.companyApp.entity.Document;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class FileUploadServiceImpl implements FileUploadService {

    private DocumentRepository documentRepository;

    public FileUploadServiceImpl(DocumentRepository documentRepository) {
        this.documentRepository = documentRepository;
    }

    @Override
    public List<Document> findAll() {
        return documentRepository.findAll();
    }

    @Override
    public Document findById(int id) {
        Optional<Document> result = documentRepository.findById(id);

        Document document = null;

        if (result.isPresent()) {
            document = result.get();
        }
        else {
            throw new RuntimeException("Did not find document id - " + id);
        }

        return document;
    }

    @Override
    public void save(MultipartFile file) throws IOException{
        Document document = new Document();
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        document.setName(filename);
        document.setData(file.getBytes());
        documentRepository.save(document);
    }

    @Override
    public void deleteById(int id) {
        documentRepository.deleteById(id);
    }
}
