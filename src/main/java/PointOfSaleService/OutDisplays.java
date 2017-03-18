package PointOfSaleService;

import DBManagement.Product;

import java.sql.*;
import java.util.*;

/**
 * Created by kalisiaczki on 15.03.2017.
 */

public class OutDisplays {

    public static List<Product> scannedProducts = new ArrayList<>();
    public static List<Product> allProducts = new ArrayList<>();


    public static void isItInDatabase (String firstColumnName, String secondColumnName, String thirdColumnName){

        Connection connection = Information.makeDBConnection();
        Statement statement = null;

        try {
            statement = connection.createStatement();

            String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                    " FROM PRODUCTS";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {

                allProducts.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));
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

        if(allProducts.stream().anyMatch(s->s.getCode()==scannedId)) {

            Connection connection = Information.makeDBConnection();
            Statement statement = null;

            try {
                statement = connection.createStatement();

                String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                        " FROM PRODUCTS WHERE " + firstColumnName + " = " + scannedId;
                ResultSet rs = statement.executeQuery(sql);

                while (rs.next()) {

                    scannedProducts.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));

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
        } else if (scannedId==0){
            System.out.println("");
        } else
            {
            System.out.println("Product not found");
            }
    }

    public static void exitDisplayAndCount ( String secondColumnName, String thirdColumnName){

        if(scannedProducts.isEmpty()){
            System.out.println("No product has been scanned!");
        }else{

            for (Product product : scannedProducts) {
                System.out.println(secondColumnName.toUpperCase() + " of the product is " + product.getName() + " and the " + thirdColumnName.toUpperCase() + " is " + product.getPrice());
            }
            int countPrice = scannedProducts.stream()
                    .filter(c->c.getPrice()>0).mapToInt(Product::getPrice).sum();
                System.out.println("Total price of the products is: " + countPrice);
        }
    }
}



