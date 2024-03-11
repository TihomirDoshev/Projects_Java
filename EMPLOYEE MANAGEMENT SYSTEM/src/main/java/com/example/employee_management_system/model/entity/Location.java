package com.example.employee_management_system.model.entity;

import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;

@Entity
@Table(name = "location")
public class Location extends BaseEntity {
    private LocationNameEnum location;

    public Location() {
    }

    @Enumerated(EnumType.STRING)
    public LocationNameEnum getLocation() {
        return location;
    }

    public Location setLocation(LocationNameEnum location) {
        this.location = location;
        return this;
    }
}
