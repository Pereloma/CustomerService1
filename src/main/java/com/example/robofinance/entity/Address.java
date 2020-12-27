package com.example.robofinance.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column
    String contry;

    @Column
    String region;

    @Column
    String city;

    @Column
    String street;

    @Column
    String house;

    @Column
    String flat;

    @Column
    Date created;

    @Column
    Date modified;


    public Address() {
        this.created = new Date();
    }


    public void modified(){
        this.modified = new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id == address.id;
    }


    @Override
    public int hashCode() {
        if (id != null) return Long.hashCode(id);
        return Objects.hash(contry, region, city, street, house, flat, created, modified);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContry() {
        return contry;
    }

    public void setContry(String contry) {
        this.contry = contry;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getFlat() {
        return flat;
    }

    public void setFlat(String flat) {
        this.flat = flat;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
