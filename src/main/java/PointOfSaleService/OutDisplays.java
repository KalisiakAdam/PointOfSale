package PointOfSaleService;

import DBManagement.H2JDBC;
import DBManagement.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kalisiaczki on 15.03.2017.
 */


public class OutDisplays {

public static List<Product> scannedProduct = new ArrayList<>();

    public static void scanProduct(String firstColumnName, String secondColumnName, String thirdColumnName, int scannedId) {
        Connection connection = Information.makeDBConnection();
        Statement statement = null;


            try {
                statement = connection.createStatement();

                String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                        " FROM PRODUCTS WHERE " + firstColumnName + " = " + scannedId;
                ResultSet rs = statement.executeQuery(sql);
                while (rs.next()) {
                    scannedProduct.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));
                }
                rs.close();

                for (Product product : scannedProduct) {
                    System.out.println(secondColumnName + " is " + product.getName() + " and the " + thirdColumnName + " is " + product.getPrice());
                }

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                } catch (SQLException se2) {

                }
                try {
                    if (connection != null) connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();
                }
            }

    }

    public static void isItInDatabase (String firstColumnName, String secondColumnName, String thirdColumnName, int scannedId){

        if(!scannedProduct.isEmpty()){

        }else{

        }

    }


}



