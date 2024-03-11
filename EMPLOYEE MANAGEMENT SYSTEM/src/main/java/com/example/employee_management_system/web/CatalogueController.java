package com.example.employee_management_system.web;

import com.example.employee_management_system.model.view.EmployeeViewModel;
import com.example.employee_management_system.model.view.EmptyEmployeeViewModel;
import com.example.employee_management_system.service.EmployeeService;
import com.example.employee_management_system.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/catalogue")
public class CatalogueController {
    private final EmployeeService employeeService;
    private final UserService userService;

    public CatalogueController(EmployeeService employeeService, UserService userService) {
        this.employeeService = employeeService;
        this.userService = userService;
    }

    @GetMapping("/departments")
    public String getDepartments() {
        return "departments";
    }

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<EmptyEmployeeViewModel> nullEmployees = employeeService.nullEmployees();
        model.addAttribute("nullEmployees", nullEmployees);
        return "users";
    }

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<EmployeeViewModel> allEmployees = employeeService.allEmployees();
        model.addAttribute("allEmployees", allEmployees);
        return "employees";
    }

}
