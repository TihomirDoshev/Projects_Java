package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Position;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import com.example.employee_management_system.repository.PositionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PositionServiceImplTest {
    private PositionServiceImpl serviceToTest;
    @Mock
    private PositionRepository mockPositionRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new PositionServiceImpl(mockPositionRepository);

    }
    @Test
    void initPositions() {
        when(mockPositionRepository.count()).thenReturn(0L);
        serviceToTest.initPosition();
        verify(mockPositionRepository, times(PositionNameEnum.values().length)).save(any(Position.class));

    }
}