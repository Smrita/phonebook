package com.example.phonebook.app.dto;

import com.example.phonebook.login.dto.User;

/**
 * Author: Pramod Bhandari
 * Date: 4/3/13
 * Time: 10:32 AM
 */

public class Contact {
    int id;
    String firstName;
    String middleName;
    String lastName;
    String phone;
    String address;
    int userId;

    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n----------------------------------------------------------------------------------------------\n");
        stringBuilder.append("Id: " + id);
        stringBuilder.append("\tName: " + firstName + ' ' + middleName + ' ' + lastName);
        stringBuilder.append("\tPhone: " + phone);
        stringBuilder.append("\tAddress: " + address);
        stringBuilder.append("\n----------------------------------------------------------------------------------------------\n");

        return stringBuilder.toString();

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
