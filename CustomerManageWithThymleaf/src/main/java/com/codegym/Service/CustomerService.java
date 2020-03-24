package com.codegym.Service;

import com.codegym.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {
    final static String SELECT_ALL_CUSTOMER = "SELECT * FROM Customer";
    final static String FIND_BY_ID = "SELECT * FROM Customer WHERE customerId=?";
    final static String SAVE_CUSTOMER = "UPDATE Customer SET customerId=?, customerName=?, customerEmail=?, customerAddress=?, customerDateOfBirth=?" +
            "WHERE customerId=?;";
    final static String DELETE_CUSTOMER = "DELETE FROM Customer WHERE customerId=?";
    final static String ADD_NEW_CUSTOMER = "INSERT INTO Customer values (?,?,?,?,?)";

    @Autowired
    SQLConnection connection;
    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customerList = new ArrayList<>();
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL_CUSTOMER);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int customerId = rs.getInt("customerId");
                String customerName = rs.getString("customerName");
                String customerEmail = rs.getString("customerEmail");
                String customerAddress = rs.getString("customerAddress");
                String customerDateOfBirth = rs.getString("customerDateOfBirth");
                customerList.add(new Customer(customerId,customerName,customerEmail,customerAddress,customerDateOfBirth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public Customer findById(int customerId) {
        Connection conn = connection.getConnection();
        Customer customer = null;
        try {
            PreparedStatement ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String customerName = rs.getString("customerName");
                String customerEmail = rs.getString("customerEmail");
                String customerAddress = rs.getString("customerAddress");
                String customerDateOfBirth = rs.getString("customerDateOfBirth");
                customer = new Customer(customerId, customerName, customerEmail, customerAddress, customerDateOfBirth);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public boolean saveCustomer(Customer customer){
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(SAVE_CUSTOMER);
            ps.setInt(1,customer.getCustomerId());
            ps.setString(2,customer.getCustomerName());
            ps.setString(3,customer.getCustomerEmail());
            ps.setString(4,customer.getCustomerAddress());
            ps.setString(5,customer.getCustomerDateOfBirth());
            ps.setInt(6,customer.getCustomerId());
            int rows=ps.executeUpdate();
            if(rows>0){
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteCustomer(int customerId){
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1,customerId);
            int rows = ps.executeUpdate();
            if(rows>0){
                conn.close();
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean addCustomer(Customer customer){
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_NEW_CUSTOMER);

            ps.setInt(1,customer.getCustomerId());
            ps.setString(2,customer.getCustomerName());
            ps.setString(3,customer.getCustomerEmail());
            ps.setString(4,customer.getCustomerAddress());
            ps.setString(5,customer.getCustomerDateOfBirth());
            int rows=ps.executeUpdate();
            if(rows>0){
                conn.close();
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<Customer> customerSearch(String query){
        Connection conn = connection.getConnection();
        String SEARCH;
        ArrayList<Customer> searchCustomerList= new ArrayList<>();
        if(!(query.equalsIgnoreCase(""))) {
            SEARCH = "SELECT * FROM Customer WHERE customerName like '%"+ query +"%' ";
            try {
                PreparedStatement ps = conn.prepareStatement(SEARCH);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int customerId = rs.getInt("customerId");
                    System.out.println("id"+customerId);
                    String customerName = rs.getString("customerName");
                    String customerEmail = rs.getString("customerEmail");
                    String customerAddress = rs.getString("customerAddress");
                    String customerDateOfBirth = rs.getString("customerDateOfBirth");
                    searchCustomerList.add(new Customer(customerId, customerName, customerEmail, customerAddress, customerDateOfBirth));
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else {
            SEARCH="SELECT * FROM Customer ORDER  BY customerId ASC";
            try {
                PreparedStatement ps = conn.prepareStatement(SEARCH);
                ResultSet rs = ps.executeQuery();

                while(rs.next()){
                    int customerId = rs.getInt("customerId");
                    System.out.println("id"+customerId);
                    String customerName = rs.getString("customerName");
                    String customerEmail = rs.getString("customerEmail");
                    String customerAddress = rs.getString("customerAddress");
                    String customerDateOfBirth = rs.getString("customerDateOfBirth");
                    searchCustomerList.add(new Customer(customerId, customerName, customerEmail, customerAddress, customerDateOfBirth));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return searchCustomerList;
    }
}
