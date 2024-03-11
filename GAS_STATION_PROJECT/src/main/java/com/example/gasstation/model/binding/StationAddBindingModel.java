package com.example.gasstation.model.binding;

import com.google.gson.annotations.Expose;
import jakarta.annotation.Nullable;

public class StationAddBindingModel {
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String brand;
    @Expose
    private String street;
    @Expose
    private String place;
    @Expose
    private Double lat;
    @Expose
    private Double lng;
    @Expose
    private Double dist;
    @Expose
    private Double diesel;
    @Expose
    private Double e5;
    @Expose
    private Double e10;
    @Expose
    private boolean isOpen;
    @Expose
    private String houseNumber;
    @Expose
    private Integer postCode;

    public StationAddBindingModel() {

    }

    public String getId() {
        return id;
    }

    public StationAddBindingModel setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public StationAddBindingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public StationAddBindingModel setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public StationAddBindingModel setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public StationAddBindingModel setPlace(String place) {
        this.place = place;
        return this;
    }

    public Double getLat() {
        return lat;
    }

    public StationAddBindingModel setLat(Double lat) {
        this.lat = lat;
        return this;
    }

    public Double getLng() {
        return lng;
    }

    public StationAddBindingModel setLng(Double lng) {
        this.lng = lng;
        return this;
    }

    public Double getDist() {
        return dist;
    }

    public StationAddBindingModel setDist(Double dist) {
        this.dist = dist;
        return this;
    }

    @Nullable
    public Double getDiesel() {
        return diesel;
    }

    public StationAddBindingModel setDiesel(Double diesel) {
        this.diesel = diesel;
        return this;
    }

    @Nullable
    public Double getE5() {
        return e5;
    }

    public StationAddBindingModel setE5(Double e5) {
        this.e5 = e5;
        return this;
    }

    @Nullable
    public Double getE10() {
        return e10;
    }

    public StationAddBindingModel setE10(Double e10) {
        this.e10 = e10;
        return this;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public StationAddBindingModel setOpen(boolean open) {
        isOpen = open;
        return this;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public StationAddBindingModel setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
        return this;
    }

    public Integer getPostCode() {
        return postCode;
    }

    public StationAddBindingModel setPostCode(Integer postCode) {
        this.postCode = postCode;
        return this;
    }
}
