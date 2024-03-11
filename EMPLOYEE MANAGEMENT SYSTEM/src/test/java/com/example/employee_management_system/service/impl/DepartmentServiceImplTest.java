package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Department;
import com.example.employee_management_system.model.entity.enums.DepartmentNameEnum;
import com.example.employee_management_system.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {
    private DepartmentServiceImpl serviceToTest;
    @Mock
    private DepartmentRepository mockDepartmentRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new DepartmentServiceImpl(mockDepartmentRepository);

    }

    @Test
    void initDepartments() {
        when(mockDepartmentRepository.count()).thenReturn(0L);
        serviceToTest.initDepartments();
        verify(mockDepartmentRepository, times(DepartmentNameEnum.values().length)).save(any(Department.class));

    }
}