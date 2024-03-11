package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Hours;
import com.example.employee_management_system.model.entity.enums.HoursNameEnum;
import com.example.employee_management_system.repository.HoursRepository;
import com.example.employee_management_system.service.HoursService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class HoursServiceImpl implements HoursService {

    private final HoursRepository hoursRepository;

    public HoursServiceImpl(HoursRepository hoursRepository) {
        this.hoursRepository = hoursRepository;
    }

    @Override
    public void initHours() {
        if (hoursRepository.count() > 0) {
            return;
        }
        Arrays.stream(HoursNameEnum.values()).forEach(hoursNameEnum -> {
            Hours hours = new Hours();
            hours.setHours(hoursNameEnum);
            hoursRepository.save(hours);
        });
    }
}
