package com.example.employee_management_system.web;

import com.example.employee_management_system.model.binding.EmployeeFillInfoBindingModel;
import com.example.employee_management_system.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/edit")
public class EditController {
    private final EmployeeService employeeService;

    public EditController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees/{id}")
    public String edit(@PathVariable Long id, Model model) {
        EmployeeFillInfoBindingModel employeeFillInfoBindingModel = employeeService.findByIDTEST(id);
        model.addAttribute("employeeFillInfoBindingModel", employeeFillInfoBindingModel);
        return "edit-user";
    }

    @PostMapping("/employees/{id}")
    public String editPost(@PathVariable Long id,
                           @Valid EmployeeFillInfoBindingModel employeeFillInfoBindingModel,
                           BindingResult bindingResult,
                           RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("employeeFillInfoBindingModel", employeeFillInfoBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.employeeFillInfoBindingModel", bindingResult);
            return "redirect:employees/{id}";
        }

        employeeService.fillDataWithMoreEmployeeInfo(id, employeeFillInfoBindingModel);

        return "redirect:/";
    }

    @ModelAttribute
    public EmployeeFillInfoBindingModel employeeFillInfoBindingModel() {
        return new EmployeeFillInfoBindingModel();
    }
}
