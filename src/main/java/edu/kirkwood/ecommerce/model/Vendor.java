package edu.kirkwood.ecommerce.model;

public class Vendor {
    private String vend_id;
    private String vend_name;
    private Address address;

    public Vendor() {
    }

    public Vendor(String vend_id, String vend_name, Address address) {
        setVend_id(vend_id);
        setVend_name(vend_name);
        setAddress(address);
    }

    public String getVend_id() {
        return vend_id;
    }

    public void setVend_id(String vend_id) {
        if(vend_id == null || vend_id.strip().length() == 0) {
            throw new IllegalArgumentException("Vendor ID is required");
        }
        this.vend_id = vend_id;
    }

    public String getVend_name() {
        return vend_name;
    }

    public void setVend_name(String vend_name) {
        if(vend_name == null || vend_name.strip().length() == 0) {
            throw new IllegalArgumentException("Vendor Name is required");
        }
        this.vend_name = vend_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        if(address == null) {
            throw new IllegalArgumentException("Address is required");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Vendor{" +
                "vend_id='" + vend_id + '\'' +
                ", vend_name='" + vend_name + '\'' +
                ", address=" + address +
                '}';
    }
}
