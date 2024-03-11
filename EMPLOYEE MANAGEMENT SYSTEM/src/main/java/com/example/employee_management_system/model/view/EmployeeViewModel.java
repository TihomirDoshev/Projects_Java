package com.example.employee_management_system.model.view;


import com.example.employee_management_system.model.entity.Location;

import java.time.LocalDate;

public class EmployeeViewModel {
    private Long id;
    private String fullName;
    private String email;
    private String mobilePhone;
    private LocalDate birthday;
    private LocalDate hiredOn;
    private Location location;
    private String town;
    private String street;
    private String position;
    private String department;
    private String user;

    public EmployeeViewModel() {
    }

    public Long getId() {
        return id;
    }

    public EmployeeViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public EmployeeViewModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeViewModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public EmployeeViewModel setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public EmployeeViewModel setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDate getHiredOn() {
        return hiredOn;
    }

    public EmployeeViewModel setHiredOn(LocalDate hiredOn) {
        this.hiredOn = hiredOn;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public EmployeeViewModel setLocation(Location location) {
        this.location = location;
        return this;
    }

    public String getTown() {
        return town;
    }

    public EmployeeViewModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public EmployeeViewModel setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeViewModel setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getDepartment() {
        return department;
    }

    public EmployeeViewModel setDepartment(String department) {
        this.department = department;
        return this;
    }

    public String getUser() {
        return user;
    }

    public EmployeeViewModel setUser(String user) {
        this.user = user;
        return this;
    }
}
