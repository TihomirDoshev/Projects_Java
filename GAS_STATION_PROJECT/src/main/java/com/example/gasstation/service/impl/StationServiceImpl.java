package com.example.gasstation.service.impl;

import com.example.gasstation.model.binding.StationAddBindingModel;
import com.example.gasstation.model.entity.Station;
import com.example.gasstation.repository.StationRepository;
import com.example.gasstation.service.StationService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class StationServiceImpl implements StationService {
    private final StationRepository stationRepository;
    private final ModelMapper modelMapper;

    public StationServiceImpl(StationRepository stationRepository, ModelMapper modelMapper) {
        this.stationRepository = stationRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initStations() throws IOException {

        if (stationRepository.count() > 0) {
            return;
        }

        String jsonString = new String(new URL("https://wejago.de/assets/data/gas-stations-data.json")
                .openStream()
                .readAllBytes());

        String[] splitArray = jsonString
                .split("([:{\\]\\[}\\s+]+)\\s+");

        StationAddBindingModel currentStationAddBindingModel = new StationAddBindingModel();

        List<StationAddBindingModel> filledDtoList = new LinkedList<>();

        getClearStringsFromJsonData(splitArray, currentStationAddBindingModel, filledDtoList);

        saveEntityToTheDataBase(filledDtoList);
    }

    @Override
    public List<Station> findAllStations() {
        return stationRepository.findAll();
    }

    @Override
    public Station getMaxDiesel() {
        return stationRepository.findMaxDiesel();
    }

    @Override
    public Station getMaxE5() {
        return stationRepository.findMaxE5();
    }

    @Override
    public Station getMaxE10() {
        return stationRepository.findMaxE10();
    }

    @Override
    public Station getMinDiesel() {
        return stationRepository.findMinDiesel();
    }

    @Override
    public Station getMinE5() {
        return stationRepository.findMinE5();
    }

    @Override
    public Station getMinE10() {
        return stationRepository.findMinE10();
    }

    @Override
    public List<Station> getAllByDieselEquals(Double dieselValue) {
        return stationRepository.findAllByDieselEquals(dieselValue);
    }

    @Override
    public List<Station> getAllByE5Equals(Double e5Value) {
        return stationRepository.findAllByE5Equals(e5Value);
    }

    @Override
    public List<Station> getAllByE10Equals(Double e10Value) {
        return stationRepository.findAllByE10Equals(e10Value);
    }

    @Override
    public double getAverageDieselSum() {
        return stationRepository.findSumForDiesel();
    }

    @Override
    public int getCountOfStationsDiesel() {
        return stationRepository.countStationsByDieselNotNull();
    }

    @Override
    public double getAverageE5Sum() {
        return stationRepository.findSumForE5();
    }

    @Override
    public int getCountOfStationsE5() {
        return stationRepository.countStationsByE5NotNull();
    }

    @Override
    public double getAverageE10Sum() {
        return stationRepository.findSumForE10();
    }

    @Override
    public int getCountOfStationsE10() {
        return stationRepository.countStationsByE10NotNull();
    }

    @Override
    public List<Station> getAllByName(String name) {
        return stationRepository.findAllByName(name);
    }

    private void saveEntityToTheDataBase(List<StationAddBindingModel> filledDtoList) {
        filledDtoList
                .stream()
                .map(stationAddBindingModel -> {
                    if (stationAddBindingModel.isOpen()) {
                        String idAsString = stationAddBindingModel.getId().toString();
                        stationAddBindingModel.setId(idAsString);
                        stationRepository
                                .save(modelMapper.map(stationAddBindingModel, Station.class));
                    }
                    return stationAddBindingModel;
                }).collect(Collectors.toList());
    }

    private static void getClearStringsFromJsonData(String[] splitArray, StationAddBindingModel currentStationAddBindingModel, List<StationAddBindingModel> filledDtoList) {
        for (int i = 2; i < splitArray.length - 1; i++) {

            String clearString = splitArray[i].replaceAll("\"", "");

            switch (clearString) {
                case "id" ->
                        currentStationAddBindingModel.setId(String.valueOf(UUID.fromString((splitArray[i + 1].replaceAll("[\\\\\",]", "")))));
                case "name" -> currentStationAddBindingModel.setName(splitArray[i + 1].replaceAll("[\\\\\",]", ""));
                case "brand" -> currentStationAddBindingModel.setBrand(splitArray[i + 1].replaceAll("[\\\\\",]", ""));
                case "street" -> currentStationAddBindingModel.setStreet(splitArray[i + 1].replaceAll("[\\\\\",]", ""));
                case "place" -> currentStationAddBindingModel.setPlace(splitArray[i + 1].replaceAll("[\\\\\",]", ""));
                case "lat" ->
                        currentStationAddBindingModel.setLat(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                case "lng" ->
                        currentStationAddBindingModel.setLng(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                case "dist" ->
                        currentStationAddBindingModel.setDist(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                case "diesel", "diessel" -> {
                    if ((splitArray[i + 1].equals("null,"))) {
                        currentStationAddBindingModel.setDiesel(null);
                    } else {
                        currentStationAddBindingModel.setDiesel(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                    }
                }
                case "e5" -> {
                    if ((splitArray[i + 1].equals("null,"))) {
                        currentStationAddBindingModel.setE5(null);
                    } else {
                        currentStationAddBindingModel.setE5(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                    }
                }
                case "e10" -> {
                    if ((splitArray[i + 1].equals("null,"))) {
                        currentStationAddBindingModel.setE10(null);
                    } else {
                        currentStationAddBindingModel.setE10(Double.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                    }
                }
                case "isOpen" ->
                        currentStationAddBindingModel.setOpen(Boolean.parseBoolean(splitArray[i + 1].replaceAll("[\\\\\",]", "")));
                case "houseNumber" ->
                        currentStationAddBindingModel.setHouseNumber(splitArray[i + 1].replaceAll("[\\\\\",]", ""));
                case "postCode" -> {
                    currentStationAddBindingModel.setPostCode(Integer.valueOf(splitArray[i + 1].replaceAll("[\\\\\",]", "")));


                    filledDtoList.add(currentStationAddBindingModel);
                    currentStationAddBindingModel = new StationAddBindingModel();
                }
            }
        }
    }
}
