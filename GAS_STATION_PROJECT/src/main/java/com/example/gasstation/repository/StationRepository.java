package com.example.gasstation.repository;

import com.example.gasstation.model.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StationRepository extends JpaRepository<Station, String> {
    @Query(value = "SELECT * FROM `gas-station`.stations WHERE diesel IS NOT NULL ORDER BY diesel DESC LIMIT 1", nativeQuery = true)
    Station findMaxDiesel();

    @Query(value = "SELECT * FROM `gas-station`.stations WHERE e5 IS NOT NULL ORDER BY e5 DESC LIMIT 1", nativeQuery = true)
    Station findMaxE5();

    @Query(value = "SELECT * FROM `gas-station`.stations WHERE e10 IS NOT NULL ORDER BY e10 DESC LIMIT 1", nativeQuery = true)
    Station findMaxE10();

    @Query(value = "SELECT * FROM `gas-station`.stations WHERE diesel IS NOT NULL ORDER BY diesel LIMIT 1", nativeQuery = true)
    Station findMinDiesel();

    @Query(value = "SELECT * FROM `gas-station`.stations WHERE e5 IS NOT NULL ORDER BY e5 LIMIT 1", nativeQuery = true)
    Station findMinE5();

    @Query(value = "SELECT * FROM `gas-station`.stations WHERE e10 IS NOT NULL ORDER BY e10 LIMIT 1", nativeQuery = true)
    Station findMinE10();

    @Query(value = "SELECT SUM(diesel) FROM `gas-station`.stations;", nativeQuery = true)
    double findSumForDiesel();

    @Query(value = "SELECT SUM(e5) FROM `gas-station`.stations;", nativeQuery = true)
    double findSumForE5();

    @Query(value = "SELECT SUM(e10) FROM `gas-station`.stations;", nativeQuery = true)
    double findSumForE10();

    List<Station> findAllByE10Equals(Double e10);

    List<Station> findAllByE5Equals(Double e5);

    List<Station> findAllByDieselEquals(Double diesel);

    List<Station> findAllByName(String name);

    int countStationsByDieselNotNull();

    int countStationsByE5NotNull();

    int countStationsByE10NotNull();
}
