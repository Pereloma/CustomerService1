package com.example.robofinance.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIgnoreType;
import com.fasterxml.jackson.annotation.JsonSetter;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "customer")
@Entity(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "registred_address_id")
    private Address registredAddressID;

    @ManyToOne(optional = false)
    @JoinColumn(name = "actual_address_id")
    private Address actualAddressID;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(nullable = false)
    private String sex;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        if(id != null || customer.id !=null) {
            if ((id == customer.id)) return true;
            return Objects.equals(registredAddressID, customer.registredAddressID) && Objects.equals(actualAddressID, customer.actualAddressID) && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(middleName, customer.middleName) && Objects.equals(sex, customer.sex);
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (id != null) return Long.hashCode(id);
        return Objects.hash(registredAddressID, actualAddressID, firstName, lastName, middleName, sex);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getRegistredAddressID() {
        return registredAddressID;
    }

    public void setRegistredAddressID(Address registredAddressID) {
        this.registredAddressID = registredAddressID;
    }

    public Address getActualAddressID() {
        return actualAddressID;
    }

    public void setActualAddressID(Address actualAddressID) {
        this.actualAddressID = actualAddressID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", registredAddressID=" + registredAddressID +
                ", actualAddressID=" + actualAddressID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }
}
