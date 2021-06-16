package com.deverott.wolffitnesapp.registro;



public class userData {
    String name, lastName, email, password, whatsapp, birthDate, role, height, state, startDate;

    public userData() {
    }

    public userData(String name, String lastName, String email, String password, String whatsapp, String birthDate, String role, String height, String state, String startDate) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.whatsapp = whatsapp;
        this.birthDate = birthDate;
        this.role = role;
        this.height = height;
        this.state = state;
        this.startDate = startDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
}
