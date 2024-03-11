package com.example.employee_management_system.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address extends BaseEntity {
    private Location location;
    private String town;
    private String street;

    public Address() {

    }

    @ManyToOne
    public Location getLocation() {
        return location;
    }

    public Address setLocation(Location location) {
        this.location = location;
        return this;
    }

    @Column(name = "town", nullable = false, columnDefinition = "TEXT")
    public String getTown() {
        return town;
    }

    public Address setTown(String town) {
        this.town = town;
        return this;
    }

    @Column(name = "street", nullable = false, columnDefinition = "TEXT")
    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }
}