package com.example.employee_management_system.repository;

import com.example.employee_management_system.model.entity.Location;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Location findLocationByLocation(LocationNameEnum location);
}
