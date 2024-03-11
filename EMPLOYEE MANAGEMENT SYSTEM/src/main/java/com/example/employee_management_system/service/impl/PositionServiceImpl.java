package com.example.employee_management_system.service.impl;

import com.example.employee_management_system.model.entity.Position;
import com.example.employee_management_system.model.entity.enums.PositionNameEnum;
import com.example.employee_management_system.repository.PositionRepository;
import com.example.employee_management_system.service.PositionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {
        this.positionRepository = positionRepository;
    }

    @Override
    public void initPosition() {

        if (positionRepository.count() > 0) {
            return;
        }
        Arrays.stream(PositionNameEnum.values()).forEach(positionNameEnum -> {
            Position position = new Position();
            position.setPosition(positionNameEnum);
            positionRepository.save(position);
        });
    }
}
