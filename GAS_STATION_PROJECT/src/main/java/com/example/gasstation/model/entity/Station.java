package com.example.gasstation.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "stations")
public class Station extends BaseEntity {
    private String name;
    private String brand;
    private String street;
    private String place;
    private Double lat;
    private Double lng;
    private Double dist;
    private Double diesel;
    private Double e5;
    private Double e10;
    private boolean isOpen;
    private String houseNumber;
    private Integer postCode;

    public Station() {

    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public Station setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "brand")
    public String getBrand() {
        return brand;
    }

    public Station setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public Station setStreet(String street) {
        this.street = street;
        return this;
    }

    @Column(name = "place")
    public String getPlace() {
        return place;
    }

    public Station setPlace(String place) {
        this.place = place;
        return this;
    }

    @Column(name = "lat")
    public Double getLat() {
        return lat;
    }

    public Station setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    @Column(name = "lng")
    public Double getLng() {
        return lng;
    }

    public Station setLng(Double lng) {
        this.lng = lng;
        return this;
    }

    @Column(name = "dist")
    public Double getDist() {
        return dist;
    }

    public Station setDist(Double dist) {
        this.dist = dist;
        return this;
    }

    @Column(name = "diesel", nullable = true)
    public Double getDiesel() {
        return diesel;
    }

    public Station setDiesel(Double diesel) {
        this.diesel = diesel;
        return this;
    }

    @Column(name = "e5", nullable = true)
    public Double getE5() {
        return e5;
    }

    public Station setE5(Double e5) {
        this.e5 = e5;
        return this;
    }

    @Column(name = "e10", nullable = true)
    public Double getE10() {
        return e10;
    }

    public Station setE10(Double e10) {
        this.e10 = e10;
        return this;
    }

    @Column(name = "is_open")
    public boolean isOpen() {
        return isOpen;
    }

    public Station setOpen(boolean open) {
        isOpen = open;
        return this;
    }

    @Column(name = "house_number")
    public String getHouseNumber() {
        return houseNumber;
    }

    public Station setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    @Column(name = "post_code")
    public Integer getPostCode() {
        return postCode;
    }

    public Station setPostCode(Integer postCode) {
        this.postCode = postCode;
        return this;
    }
}
