package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Department;
import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import com.example.employee_management_system.repository.DepartmentRepository;
import com.example.employee_management_system.service.DepartmentService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @Override
    public void initDepartments() {
        if (departmentRepository.count() > 0) {
            return;
        }
        Arrays
                .stream(DepartmentNameEnum.values())
                .forEach(departmentNameEnum -> {
                    Department department = new Department();
                    department.setDepartment(departmentNameEnum);
                    departmentRepository.save(department);
                });
    }
}
