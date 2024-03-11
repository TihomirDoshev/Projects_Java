package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.binding.UserRegisterBindingModel;
import com.example.employee_management_system.model.entity.User;
import com.example.employee_management_system.repository.RoleRepository;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final String defaultPasswordForBoss;
    private final String defaultPasswordForModerator;
    private final String defaultPasswordForEmployee;
    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder,
                           @Value("${spring.EMPLOYEE MANAGEMENT SYSTEM.boss.defaultPasswordForBoss}") String bossPassword,
                           @Value("${spring.EMPLOYEE MANAGEMENT SYSTEM.moderator.defaultPasswordForModerator}") String moderatorPassword,
                           @Value("${spring.EMPLOYEE MANAGEMENT SYSTEM.employee.defaultPasswordForEmployee}") String employeePassword, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.defaultPasswordForBoss = bossPassword;
        this.defaultPasswordForModerator = moderatorPassword;
        this.defaultPasswordForEmployee = employeePassword;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initUsers() {
        if (userRepository.count() > 0) {
            return;
        }
        initDefaultAdmin();
        initDefaultModerator();
        initDefaultUser();
    }

    @Override
    public boolean checkUsername(String username) {
        Optional<User> userByUsername = userRepository.findUserByUsername(username);
        return userByUsername.isPresent();
    }

    @Override
    public void registerUser(UserRegisterBindingModel userRegisterBindingModel) {
        User user = new User();
        user.setRoles(roleRepository.findById(3L).stream().toList())
                .setUsername(userRegisterBindingModel.getUsername())
                .setPassword(passwordEncoder.encode(userRegisterBindingModel.getPassword()));
        userRepository.save(user);

    }


    private void initDefaultUser() {
        User user = new User();
        user
                .setUsername("User")
                .setPassword(passwordEncoder.encode(defaultPasswordForEmployee))
                .setRoles(roleRepository.findById(3L).stream().toList());
        userRepository.save(user);
    }

    private void initDefaultModerator() {
        User moderatorUser = new User();
        moderatorUser
                .setUsername("Moderator")
                .setPassword(passwordEncoder.encode(defaultPasswordForModerator))
                .setRoles(roleRepository.findById(2L).stream().toList());
        ;
        userRepository.save(moderatorUser);
    }

    private void initDefaultAdmin() {
        User bossUser = new User();
        bossUser
                .setUsername("Boss")
                .setPassword(passwordEncoder.encode(defaultPasswordForBoss))
                .setRoles(roleRepository.findById(1L).stream().toList());
        userRepository.save(bossUser);
    }
}
