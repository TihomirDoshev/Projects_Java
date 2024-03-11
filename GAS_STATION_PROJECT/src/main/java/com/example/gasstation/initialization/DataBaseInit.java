package com.example.gasstation.initialization;

import com.example.gasstation.service.StationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataBaseInit implements CommandLineRunner {
    public final StationService stationService;

    public DataBaseInit(StationService stationService) {
        this.stationService = stationService;
    }

    @Override
    public void run(String... args) throws Exception {

        stationService.initStations();

    }
}
