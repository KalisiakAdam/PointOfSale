package PointOfSaleService;

import DBManagement.H2JDBC;
import DBManagement.Product;

import java.sql.*;
import java.util.*;

/**
 * Created by kalisiaczki on 15.03.2017.
 */


public class OutDisplays {

    public static List<Product> scannedProduct = new ArrayList<>();
    public static List<Product> allProduct = new ArrayList<>();


    public static void isItInDatabase (String firstColumnName, String secondColumnName, String thirdColumnName, int scannedId){

        Connection connection = Information.makeDBConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                    " FROM PRODUCTS";
            ResultSet rs = statement.executeQuery(sql);


            while (rs.next()) {
                allProduct.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));
            }
            rs.close();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
            }  catch (SQLException e) {
                e.printStackTrace();

            }
            try {
                if (connection != null) connection.close();
            } catch (SQLException se) {
                se.printStackTrace();

            }
        }

    }

    public static void scanProduct(String firstColumnName, String secondColumnName, String thirdColumnName, int scannedId) {

        if(allProduct.stream().anyMatch(s->s.getCode()==scannedId)) {

            Connection connection = Information.makeDBConnection();
            Statement statement = null;

            try {
                statement = connection.createStatement();

                String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                        " FROM PRODUCTS WHERE " + firstColumnName + " = " + scannedId;
                ResultSet rs = statement.executeQuery(sql);


                while (rs.next()) {

                    scannedProduct.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));

                    int firstColumnScanedToDisplay = rs.getInt(firstColumnName);
                    String secondCoulmnScanedToDisplay = rs.getString(secondColumnName);
                    int thirdColumnScanedToDisplay = rs.getInt(thirdColumnName);

                    System.out.println(firstColumnName + ": " + firstColumnScanedToDisplay);
                    System.out.println(secondColumnName + ": " + secondCoulmnScanedToDisplay);
                    System.out.println(thirdColumnName + ": " + thirdColumnScanedToDisplay);
                }

                rs.close();

            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();

                }
                try {
                    if (connection != null) connection.close();
                } catch (SQLException se) {
                    se.printStackTrace();

                }
            }
        }else
        {
            System.out.println("errror");
        }

    }

    public static void exitDisplayAndCount ( String secondColumnName, String thirdColumnName){

        if(scannedProduct.isEmpty()){

            System.out.println("No product has been scanned!");

        }else{

            for (Product product : scannedProduct) {
                System.out.println(secondColumnName.toUpperCase() + " is " + product.getName() + " and the " + thirdColumnName.toUpperCase() + " is " + product.getPrice());
            }
            int countPrice = scannedProduct.stream()
                    .filter(c->c.getPrice()>0).mapToInt(Product::getPrice).sum();
            System.out.println("Total price is: " + countPrice);

        }

    }


}



