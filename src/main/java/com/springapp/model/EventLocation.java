package com.springapp.model;

/**
 * Created by mk on 2016-12-27.
 */
public class EventLocation {

    private String address;
    private String city;
    private String province;

    public EventLocation() {};

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
