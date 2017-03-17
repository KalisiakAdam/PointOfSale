package PointOfSaleService;

import DBManagement.H2JDBC;
import DBManagement.SystemManagment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kalisiaczki on 17.03.2017.
 */
public class Information {

    public static void welcomeFirst(){
        System.out.println("Welcom in Point of Sale Application");
        System.out.println("First named three column of new Table!\n");
    }

    public static void welcome(){

        System.out.println("Please select number from 1 to 4 from menu:");
        System.out.println("1. Insert Product parameters in fallowing column");
        System.out.println("2. Create sample of 3 different products database (id, name, price)");
        System.out.println("3. Scan product");
        System.out.println("4. Exit");

    }

    public static Connection makeDBConnection(){

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