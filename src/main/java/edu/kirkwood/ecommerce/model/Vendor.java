package edu.kirkwood.ecommerce.model;

public class Vendor {
    private String vend_id;
    private String vend_name;
    private Address address;

    public Vendor() {
    }

    public Vendor(String vend_id, String vend_name, Address address) {
        this.vend_id = vend_id;
        this.vend_name = vend_name;
        this.address = address;
    }

    public String getVend_id() {
        return vend_id;
    }

    public void setVend_id(String vend_id) {
        this.vend_id = vend_id;
    }

    public String getVend_name() {
        return vend_name;
    }

    public void setVend_name(String vend_name) {
        this.vend_name = vend_name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
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
