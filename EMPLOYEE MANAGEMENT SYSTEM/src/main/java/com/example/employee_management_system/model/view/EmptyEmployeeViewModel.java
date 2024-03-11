package com.example.employee_management_system.model.view;

public class EmptyEmployeeViewModel {
    private Long userID;
    private String username;

    public EmptyEmployeeViewModel() {
    }

    public Long getUserID() {
        return userID;
    }

    public EmptyEmployeeViewModel setUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public EmptyEmployeeViewModel setUsername(String username) {
        this.username = username;
        return this;
    }
}
