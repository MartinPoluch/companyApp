package com.poluch.martin.companyApp.dao;

import com.poluch.martin.companyApp.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
