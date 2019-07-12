package com.example.smartparkingsystem.Model;

public class Parking {
    private String password;
    private String parkingName;
    private String parkingStatus;
    private int userId;
    private int parkingId;
    private String username;

    public Parking() {
        this.password = password;
        this.parkingName = parkingName;
        this.parkingStatus = parkingStatus;
        this.userId = userId;
        this.parkingId = parkingId;
        this.username = username;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingStatus() {
        return parkingStatus;
    }

    public void setParkingStatus(String parkingStatus) {
        this.parkingStatus = parkingStatus;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getParkingId() {
        return parkingId;
    }

    public void setParkingId(int parkingId) {
        this.parkingId = parkingId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
