package edu.kirkwood.ecommerce.model;

import edu.kirkwood.shared.Validators;

public class Address {
    private String address;
    private String city;
    private String state;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String address, String city, String state, String zip, String country) {
        setAddress(address);
        setCity(city);
        setState(state);
        setZip(zip);
        setCountry(country);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address == null || address.strip().length() == 0) {
            throw new IllegalArgumentException("Street address is required");
        }
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        if(city == null || city.strip().length() == 0) {
            throw new IllegalArgumentException("City is required");
        }
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        // TODO: Require the state if the country is US or USA or not specified
        if(state != null && state.strip().length() > 0 && Validators.isValidState(state)) {
            throw new IllegalArgumentException("Invalid state");
        }
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        if(zip == null || Validators.isValidZip(zip)) {
            throw new IllegalArgumentException("Invalid zip");
        }
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        if(country == null || Validators.isValidCountry(country)) {
            throw new IllegalArgumentException("Invalid country");
        }
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip='" + zip + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}

