package CustomerManage.Service;

import CustomerManage.Model.Customer;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerService {
    final static String SELECT_ALL_CUSTOMER = "SELECT * FROM Customer";
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
        return customerList;
    }

}
