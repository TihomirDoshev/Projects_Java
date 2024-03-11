package com.example.employee_management_system.model.entity;

import com.example.employee_management_system.model.entity.enums.HoursNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "hours")
public class Hours extends BaseEntity {
    private HoursNameEnum hours;

    public Hours() {
    }

    @Enumerated(EnumType.STRING)
    public HoursNameEnum getHours() {
        return hours;
    }

    public Hours setHours(HoursNameEnum hours) {
        this.hours = hours;
        return this;
    }
}
