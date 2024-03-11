package com.example.employee_management_system.model.entity;

import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "departments")
public class Department extends BaseEntity {
    private DepartmentNameEnum department;

    public Department() {
    }

    @Enumerated(EnumType.STRING)
    public DepartmentNameEnum getDepartment() {
        return department;
    }

    public Department setDepartment(DepartmentNameEnum department) {
        this.department = department;
        return this;
    }
}