package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Role;
import com.example.employee_management_system.model.entity.enums.RoleNameEnum;
import com.example.employee_management_system.repository.RoleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RoleServiceImplTest {
    private RoleServiceImpl serviceToTest;
    @Mock
    private RoleRepository mockRoleRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new RoleServiceImpl(mockRoleRepository);

    }
    @Test
    void initRoles() {
        when(mockRoleRepository.count()).thenReturn(0L);
        serviceToTest.initRoles();
        verify(mockRoleRepository, times(RoleNameEnum.values().length)).save(any(Role.class));

    }
}