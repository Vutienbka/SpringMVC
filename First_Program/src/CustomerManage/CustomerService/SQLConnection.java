package CustomerManage.CustomerService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnection {

        final static String URL = "jdbc:mysql://localhost:3306/Customer";
        final static String USERNAME = "root";
        final static String PASSWORD = "123456";

        public SQLConnection() {
        }

        public static Connection getConnection() {
            Connection connection = null;
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            }catch (SQLException | ClassNotFoundException e){
                e.printStackTrace();
            }
            return connection;
        }
}
