package com.example.employee_management_system.repository;

import com.example.employee_management_system.model.entity.Position;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {
    Position findPositionByPosition(PositionNameEnum position);
}
