package com.example.gasstation.web;

import com.example.gasstation.model.entity.Station;
import com.example.gasstation.service.StationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class Controller {
    private final StationService stationService;

    public Controller(StationService stationService) {
        this.stationService = stationService;
    }

    @GetMapping("/json")
    public ResponseEntity<Object> test() throws IOException {
        String jsonString = new String(new URL("https://wejago.de/assets/data/gas-stations-data.json")
                .openStream()
                .readAllBytes());
        return ResponseEntity.ok(jsonString);
    }

    @GetMapping("/api/stations")
    public ResponseEntity<List<Station>> getAllStations() {
        List<Station> all = stationService.findAllStations();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/api/max/diesel")
    public ResponseEntity<List<Station>> getMaxDieselStation() {
        Station maxDiesel = stationService.getMaxDiesel();
        Double dieselValue = maxDiesel.getDiesel();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByDieselEquals(dieselValue);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/max/e5")
    public ResponseEntity<List<Station>> getMaxE5Station() {
        Station maxE5 = stationService.getMaxE5();
        Double e5Value = maxE5.getE5();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByE5Equals(e5Value);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/max/e10")
    public ResponseEntity<List<Station>> getMaxE10Station() {
        Station maxE10 = stationService.getMaxE10();
        Double e10Value = maxE10.getE10();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByE10Equals(e10Value);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/min/diesel")
    public ResponseEntity<List<Station>> getMinDieselStation() {
        Station minDiesel = stationService.getMinDiesel();
        Double dieselValue = minDiesel.getDiesel();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByDieselEquals(dieselValue);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/min/e5")
    public ResponseEntity<List<Station>> getMinE5Station() {
        Station minE5 = stationService.getMinE5();
        Double e5Value = minE5.getE5();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByE5Equals(e5Value);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/min/e10")
    public ResponseEntity<List<Station>> getMinE10Station() {
        Station minE10 = stationService.getMinE10();
        Double e10Value = minE10.getE10();
        List<Station> oneOrMoreStationsWithEqualValue = stationService.getAllByE10Equals(e10Value);
        return ResponseEntity.ok(oneOrMoreStationsWithEqualValue);
    }

    @GetMapping("/api/station/{name}")
    public ResponseEntity<List<Station>> findStationsByGivenName(@PathVariable("name") String name) {
        List<Station> stations = stationService.getAllByName(name);
        return ResponseEntity.ok(stations);
    }

    @GetMapping("/api/average/diesel")
    public String getAverageDieselValue() {
        double averageDieselSum = stationService.getAverageDieselSum();
        int countOfAllStationsWithDieselValueNotEmpty = stationService.getCountOfStationsDiesel();
        double average = averageDieselSum / countOfAllStationsWithDieselValueNotEmpty;
        return String.format("Average diesel for all Gas-Stations with filled Diesel value is " + average + ".");
    }

    @GetMapping("/api/average/e5")
    public String getAverageE5Value() {
        double averageE5Sum = stationService.getAverageE5Sum();
        int countOfAllStationsWithE5ValueNotEmpty = stationService.getCountOfStationsE5();
        double average = averageE5Sum / countOfAllStationsWithE5ValueNotEmpty;
        return String.format("Average E5 for all Gas-Stations with filled E5 value is " + average + ".");
    }

    @GetMapping("/api/average/e10")
    public String getAverageE10Value() {
        double averageE10Sum = stationService.getAverageE10Sum();
        int countOfAllStationsWithE10ValueNotEmpty = stationService.getCountOfStationsE10();
        double average = averageE10Sum / countOfAllStationsWithE10ValueNotEmpty;
        return String.format("Average E10 for all Gas-Stations with filled E10 value is " + average + ".");
    }
}
