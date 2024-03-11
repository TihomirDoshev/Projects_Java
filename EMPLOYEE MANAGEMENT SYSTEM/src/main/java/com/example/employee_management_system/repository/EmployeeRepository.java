package com.example.employee_management_system.repository;

import com.example.employee_management_system.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findAllByFullNameIsNotNull();

    List<Employee> findAllByFullNameIsNull();
}
