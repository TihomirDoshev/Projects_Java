package com.example.gasstation.service;

import com.example.gasstation.model.entity.Station;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.List;

public interface StationService {
    void initStations() throws IOException, ParseException;

    List<Station> getAllByName(String name);

    List<Station> getAllByE10Equals(Double e10Value);

    List<Station> getAllByE5Equals(Double e5Value);

    List<Station> getAllByDieselEquals(Double dieselValue);

    List<Station> findAllStations();

    Station getMaxE10();

    Station getMaxE5();

    Station getMaxDiesel();

    Station getMinE10();

    Station getMinE5();

    Station getMinDiesel();

    double getAverageDieselSum();

    int getCountOfStationsDiesel();

    double getAverageE5Sum();

    int getCountOfStationsE5();

    double getAverageE10Sum();

    int getCountOfStationsE10();
}
