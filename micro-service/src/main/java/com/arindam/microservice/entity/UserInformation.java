package com.arindam.microservice.entity;

public class UserInformation {

    private int age;

    private String gender;

    private Address address;

    public UserInformation() {
    }

    public UserInformation(String gender, Address address) {
        this.gender = gender;
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
