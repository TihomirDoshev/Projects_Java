package com.example.employee_management_system.model.binding;

import org.hibernate.validator.constraints.Length;

public class UserRegisterBindingModel {
    private String username;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters! Please enter a valid username!")
    public String getUsername() {
        return username;
    }

    public UserRegisterBindingModel setUsername(String username) {
        this.username = username;
        return this;
    }

    @Length(min = 3, max = 30, message = "Password must be between 3 and 30 characters! Please enter a valid password!")
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Length(min = 3, max = 30, message = "Confirm password must be between 3 and 30 characters! Please enter a valid confirm password!")
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
