package com.poluch.martin.companyApp.dao;

import com.poluch.martin.companyApp.entity.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
