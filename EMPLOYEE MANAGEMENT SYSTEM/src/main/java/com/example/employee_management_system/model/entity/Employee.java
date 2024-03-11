package com.example.employee_management_system.model.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
public class Employee extends BaseEntity {
    private String fullName;
    private String email;
    private String mobilePhone;
    private LocalDate birthday;
    private LocalDate hiredOn;
    private Address address;
    private Position position;
    private Department department;
    private User user;

    public Employee() {
    }

    @OneToOne
    public User getUser() {
        return user;
    }

    public Employee setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne
    public Position getPosition() {
        return position;
    }

    public Employee setPosition(Position position) {
        this.position = position;
        return this;
    }

    @ManyToOne
    public Department getDepartment() {
        return department;
    }

    public Employee setDepartment(Department department) {
        this.department = department;
        return this;
    }

    @OneToOne
    public Address getAddress() {
        return address;
    }

    public Employee setAddress(Address address) {
        this.address = address;
        return this;
    }

    @Column(name = "full_name", columnDefinition = "TEXT")
    public String getFullName() {
        return fullName;
    }

    public Employee setFullName(String fullName) {
        this.fullName = fullName;
        return this;
    }

    @Column(name = "email", columnDefinition = "TEXT")
    public String getEmail() {
        return email;
    }

    public Employee setEmail(String email) {
        this.email = email;
        return this;
    }

    @Column(name = "mobile_phone", columnDefinition = "TEXT")
    public String getMobilePhone() {
        return mobilePhone;
    }

    public Employee setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    @Column(name = "birthday")
    public LocalDate getBirthday() {
        return birthday;
    }

    public Employee setBirthday(LocalDate birthday) {
        this.birthday = birthday;
        return this;
    }

    @Column(name = "hired_on")
    public LocalDate getHiredOn() {
        return hiredOn;
    }

    public Employee setHiredOn(LocalDate hiredOn) {
        this.hiredOn = hiredOn;
        return this;
    }
}
