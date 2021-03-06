package pointOfSaleService;

import dbManagement.H2JDBC;
import java.sql.*;

/**
 * Created by kalisiaczki on 17.03.2017.
 */
public class Information {

    public void welcomeFirst(){
        System.out.println("Welcome to Point of Sale application");
        System.out.println("First please name three column of new Database with products specification!\n");
    }

    public void welcome(){

        System.out.println("\nPlease select number from 1 to 4 from menu:");
        System.out.println("1. Insert Product parameters in following column");
        System.out.println("2. Create sample of 3 different products database (id, name, price)");
        System.out.println("3. Scan product");
        System.out.println("4. Submit scanned product and Exit\n");
    }

    public Connection makeDBConnection(){

        Connection dbConnection = null;
        try{
            Class.forName(H2JDBC.DB_DRIVER);

        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try{
            dbConnection = DriverManager.getConnection(H2JDBC.DB_CONNECTION,H2JDBC.DB_USER,H2JDBC.DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }
}
