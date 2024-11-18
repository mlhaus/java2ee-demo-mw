package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection;

public class VendorDAO {

    public static void main(String[] args) {
        Vendor vendor = new Vendor("BR01", "Test Vendor", new Address("123 Example St.", "Cedar Rapids", "IA", "55555", "USA"));
        addVendor(vendor);
    }
    
    public static List<Vendor> getVendors() {
        // You should have this complete from Assignment 9
        return null;
    }

    public static boolean addVendor(Vendor vendor) {
        try(Connection connection = getConnection()) {
            CallableStatement statement = connection.prepareCall("{CALL sp_add_vendor_admin(?, ?, ?, ?, ?, ?, ?)}");
            statement.setString(1, vendor.getVend_id());
            statement.setString(2, vendor.getVend_name());
            statement.setString(3, vendor.getAddress().getAddress());
            statement.setString(4, vendor.getAddress().getCity());
            statement.setString(5, vendor.getAddress().getState());
            statement.setString(6, vendor.getAddress().getZip());
            statement.setString(7, vendor.getAddress().getCountry());
            int rowsAffected = statement.executeUpdate();
            return rowsAffected == 1;
        } catch(SQLException e) {
//            System.out.println(e.getMessage()); // Uncomment in case nothing is inserting
            return false;
        }
    }
}
