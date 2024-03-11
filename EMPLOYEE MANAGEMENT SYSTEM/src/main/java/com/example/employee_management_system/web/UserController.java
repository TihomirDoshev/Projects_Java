package com.example.employee_management_system.web;

import com.example.employee_management_system.model.binding.UserRegisterBindingModel;
import com.example.employee_management_system.service.EmployeeService;
import com.example.employee_management_system.service.UserService;
import jakarta.validation.Valid;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final EmployeeService employeeService;

    public UserController(UserService userService, EmployeeService employeeService) {
        this.userService = userService;
        this.employeeService = employeeService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login-error")
    public String onFailedLogin(
            @ModelAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY) String username, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_FORM_USERNAME_KEY, username);
        redirectAttributes.addFlashAttribute("bad_credential", true);
        return "redirect:/users/login";
    }


    @GetMapping("/register")
    public String register(Model model) {
        if (model.containsAttribute("usernameNotExist")) {
            model.addAttribute("usernameNotExist", true);
        }
        if (model.containsAttribute("emailNotExist")) {
            model.addAttribute("emailNotExist", true);
        }
        return "register";
    }

    @ModelAttribute
    public UserRegisterBindingModel userRegisterBindingModel() {
        return new UserRegisterBindingModel();
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterBindingModel userRegisterBindingModel, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterBindingModel.getPassword().equals(userRegisterBindingModel.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterBindingModel", bindingResult);
            return "redirect:register";
        }

        boolean checkUsername = userService.checkUsername(userRegisterBindingModel.getUsername());


        if (checkUsername) {
            redirectAttributes.addFlashAttribute("userRegisterBindingModel", userRegisterBindingModel);
            redirectAttributes.addFlashAttribute("usernameNotExist", false);
            return "redirect:register";
        }

        userService.registerUser(userRegisterBindingModel);
        employeeService.createEmptyEmploy(userRegisterBindingModel);

        return "redirect:login";
    }


    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

}
