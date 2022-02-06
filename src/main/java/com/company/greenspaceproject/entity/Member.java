package com.company.greenspaceproject.entity;

import java.io.Serializable;
import java.util.Objects;

public class Member implements Serializable {
    int mid;
    int uid;
    String firstName;
    String lastName;
    String middleName;
    int gender;
    String country;
    String state;
    String city;
    String zip;
    String address;

    @Override
    public String toString() {
        return "member{" +
                "mid=" + mid +
                ", uid=" + uid +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", gender=" + gender +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;
        Member member = (Member) o;
        return getMid() == member.getMid() && getUid() == member.getUid() && getGender() == member.getGender() && Objects.equals(getFirstName(), member.getFirstName()) && Objects.equals(getLastName(), member.getLastName()) && Objects.equals(getMiddleName(), member.getMiddleName()) && Objects.equals(getCountry(), member.getCountry()) && Objects.equals(getState(), member.getState()) && Objects.equals(getCity(), member.getCity()) && Objects.equals(getZip(), member.getZip()) && Objects.equals(getAddress(), member.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMid(), getUid(), getFirstName(), getLastName(), getMiddleName(), getGender(), getCountry(), getState(), getCity(), getZip(), getAddress());
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
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

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
