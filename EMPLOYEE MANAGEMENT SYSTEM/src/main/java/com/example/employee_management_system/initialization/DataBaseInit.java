package com.example.employee_management_system.initialization;

import com.example.employee_management_system.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {
    private final DepartmentService departmentService;
    private final HoursService hoursService;
    private final LocationService locationService;
    private final PositionService positionService;
    private final RoleService roleService;
    private final UserService userService;
    private final EmployeeService employeeService;

    public DataBaseInit(DepartmentService departmentService, HoursService hoursService, LocationService locationService, PositionService positionService, RoleService roleService, UserService userService, EmployeeService employeeService) {
        this.departmentService = departmentService;
        this.hoursService = hoursService;
        this.locationService = locationService;
        this.positionService = positionService;
        this.roleService = roleService;
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @Override
    public void run(String... args) throws Exception {
        departmentService.initDepartments();
        hoursService.initHours();
        locationService.initLocation();
        positionService.initPosition();
        roleService.initRoles();
        userService.initUsers();
        employeeService.initEmployee();

    }
}
