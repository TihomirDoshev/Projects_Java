package com.example.employee_management_system.model.binding;

import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;

import java.time.LocalDate;

public class EmployeeFillInfoBindingModel {
    private Long id;
    private String fullName;
    private String email;
    private String mobilePhone;
    private LocalDate birthday;
    private LocalDate hiredOn;
    private LocationNameEnum location;
    private String town;
    private String street;
    private PositionNameEnum position;
    private DepartmentNameEnum department;

    public EmployeeFillInfoBindingModel() {

    }

    public Long getId() {
        return id;
    }

    public EmployeeFillInfoBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getFullName() {
        return fullName;
    }

    public EmployeeFillInfoBindingModel setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeFillInfoBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public EmployeeFillInfoBindingModel setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public EmployeeFillInfoBindingModel setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    public LocalDate getHiredOn() {
        return hiredOn;
    }

    public EmployeeFillInfoBindingModel setHiredOn(LocalDate hiredOn) {
        this.hiredOn = hiredOn;
        return this;
    }

    public LocationNameEnum getLocation() {
        return location;
    }

    public EmployeeFillInfoBindingModel setLocation(LocationNameEnum location) {
        this.location = location;
        return this;
    }

    public String getTown() {
        return town;
    }

    public EmployeeFillInfoBindingModel setTown(String town) {
        this.town = town;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public EmployeeFillInfoBindingModel setStreet(String street) {
        this.street = street;
        return this;
    }

    public PositionNameEnum getPosition() {
        return position;
    }

    public EmployeeFillInfoBindingModel setPosition(PositionNameEnum position) {
        this.position = position;
        return this;
    }

    public DepartmentNameEnum getDepartment() {
        return department;
    }

    public EmployeeFillInfoBindingModel setDepartment(DepartmentNameEnum department) {
        this.department = department;
        return this;
    }
}
