package com.example.employee_management_system.model.entity;

import com.example.employee_management_system.model.entity.enums.RoleNameEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role extends BaseEntity {
    private RoleNameEnum role;

    public Role() {

    }

    @Enumerated(EnumType.STRING)
    public RoleNameEnum getRole() {
        return role;
    }

    public Role setRole(RoleNameEnum role) {
        this.role = role;
        return this;
    }
}
