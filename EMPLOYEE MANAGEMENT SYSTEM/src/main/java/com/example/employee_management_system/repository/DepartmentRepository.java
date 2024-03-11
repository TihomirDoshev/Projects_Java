package com.example.employee_management_system.repository;

import com.example.employee_management_system.model.entity.Department;
import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartment(DepartmentNameEnum department);
}
