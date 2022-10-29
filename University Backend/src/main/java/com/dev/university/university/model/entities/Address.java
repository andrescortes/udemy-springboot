package com.dev.university.university.model.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

@Embeddable//one class inside another class
public class Address implements Serializable {

    private String street;
    private String number;
    private String zipcode;
    private String dpto;
    private String floor;
    private String location;

    public Address() {
    }

    public Address(String street, String number, String zipcode, String dpto, String floor,
        String location) {
        this.street = street;
        this.number = number;
        this.zipcode = zipcode;
        this.dpto = dpto;
        this.floor = floor;
        this.location = location;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDpto() {
        return dpto;
    }

    public void setDpto(String dpto) {
        this.dpto = dpto;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Address{" +
            "street='" + street + '\'' +
            ", number='" + number + '\'' +
            ", zipcode='" + zipcode + '\'' +
            ", dpto='" + dpto + '\'' +
            ", floor='" + floor + '\'' +
            ", location='" + location + '\'' +
            '}';
    }
}
