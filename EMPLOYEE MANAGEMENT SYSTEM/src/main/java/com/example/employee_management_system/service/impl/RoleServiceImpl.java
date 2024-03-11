package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Role;
import com.example.employee_management_system.model.entity.enums.RoleNameEnum;
import com.example.employee_management_system.repository.RoleRepository;
import com.example.employee_management_system.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void initRoles() {
        if (roleRepository.count() > 0) {
            return;
        }

        Arrays.stream(RoleNameEnum.values())
                .forEach(roleNameEnum -> {
                    Role currentRole = new Role();
                    currentRole.setRole(roleNameEnum);
                    roleRepository.save(currentRole);
                });
    }
}
