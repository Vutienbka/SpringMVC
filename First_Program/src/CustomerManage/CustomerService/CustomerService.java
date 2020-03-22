package CustomerManage.CustomerService;

import CustomerManage.Model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {
    SQLConnection connection = new SQLConnection();
    final static String SELECT_ALL = "SELECT * FROM Customer";
    final static String ADD_ONE_CUSTOMER = "INSERT INTO Customer VALUES (?,?,?,?);";

    public ArrayList<Customer> selectAllCustomer(){
        Connection conn = connection.getConnection();
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement ps = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                int customerId = rs.getInt("customerId");
                String customerName = rs.getString("customerName");
                String email= rs.getString("email");
                String address = rs.getString("address");
                customerList.add(new Customer(customerId,customerName,email,address));
            }
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

    public boolean addCustomer(Customer customer){
        Connection conn = connection.getConnection();
        try {
            PreparedStatement ps = conn.prepareStatement(ADD_ONE_CUSTOMER);
            ps.setInt(1,customer.getCustomerId());
            ps.setString(2,customer.getName());
            ps.setString(3,customer.getEmail());
            ps.setString(4,customer.getAddress());
            int rows = ps.executeUpdate();
            if(rows>0) {
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
}
