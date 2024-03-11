package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Location;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.repository.LocationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LocationServiceImplTest {
    private LocationServiceImpl serviceToTest;
    @Mock
    private LocationRepository mockLocationRepository;

    @BeforeEach
    void setup() {
        serviceToTest = new LocationServiceImpl(mockLocationRepository);

    }
    @Test
    void initLocations() {
        when(mockLocationRepository.count()).thenReturn(0L);
        serviceToTest.initLocation();
        verify(mockLocationRepository, times(LocationNameEnum.values().length)).save(any(Location.class));

    }
}