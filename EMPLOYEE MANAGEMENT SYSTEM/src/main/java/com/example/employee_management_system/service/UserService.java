package com.example.employee_management_system.service;

import com.example.employee_management_system.model.binding.UserRegisterBindingModel;

public interface UserService {
    void initUsers();

    boolean checkUsername(String username);

    void registerUser(UserRegisterBindingModel userRegisterBindingModel);

}
