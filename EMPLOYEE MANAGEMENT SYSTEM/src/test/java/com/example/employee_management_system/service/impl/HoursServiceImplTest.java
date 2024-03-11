package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Hours;
import com.example.employee_management_system.model.entity.enums.HoursNameEnum;
import com.example.employee_management_system.repository.HoursRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HoursServiceImplTest {
    private HoursServiceImpl serviceToTest;
    @Mock
    private HoursRepository mockHourRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new HoursServiceImpl(mockHourRepository);

    }
    @Test
    void initHours() {
        when(mockHourRepository.count()).thenReturn(0L);
        serviceToTest.initHours();
        verify(mockHourRepository, times(HoursNameEnum.values().length)).save(any(Hours.class));

    }
}