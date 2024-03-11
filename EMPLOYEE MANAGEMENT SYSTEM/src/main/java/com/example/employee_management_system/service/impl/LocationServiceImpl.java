package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Location;
import com.example.employee_management_system.model.entity.enums.LocationNameEnum;
import com.example.employee_management_system.repository.LocationRepository;
import com.example.employee_management_system.service.LocationService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class LocationServiceImpl implements LocationService {


    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public void initLocation() {
        if (locationRepository.count() > 0) {
            return;
        }
        Arrays.stream(LocationNameEnum.values()).forEach(locationNameEnum -> {
            Location location = new Location();
            location.setLocation(locationNameEnum);
            locationRepository.save(location);
        });
    }
}
