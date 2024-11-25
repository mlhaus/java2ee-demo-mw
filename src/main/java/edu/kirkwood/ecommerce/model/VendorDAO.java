package edu.kirkwood.ecommerce.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static edu.kirkwood.shared.MySQL_Connect.getConnection;

public class VendorDAO {

    public static void main(String[] args) {
        Vendor vendor = new Vendor("BR01", "Test Vendor", new Address("123 Example St.", "Cedar Rapids", "IA", "55555", "USA"));
        addVendor(vendor);
    }
    
    public static List<Vendor> getVendoresultSet() {
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
    
    public static Vendor getVendor(String vend_id) {
        Vendor vendor = null;
        if(vend_id != null) {
            vend_id = vend_id.trim();
            try (Connection connection = getConnection()) {
                CallableStatement statement = connection.prepareCall("{CALL sp_get_vendor_by_id(?)}");
                statement.setString(1, vend_id);
                ResultSet resultSet = statement.executeQuery();
                // Use an if statement instead of a while loop when the SELECT query returns one record
                if (resultSet.next()) {
                    String vend_name = resultSet.getString("vend_name");
                    String vend_address = resultSet.getString("vend_address");
                    String vend_city = resultSet.getString("vend_city");
                    String vend_state = resultSet.getString("vend_state");
                    String vend_zip = resultSet.getString("vend_zip");
                    String vend_country = resultSet.getString("vend_country");
                    vendor = new Vendor(vend_id, vend_name, new Address(vend_address, vend_city, vend_state, vend_zip, vend_country));
                }
            } catch (SQLException e) {
//            System.out.println(e.getMessage()); // Uncomment in case null is always being returned
            }
        }
        return vendor;
    }
}
