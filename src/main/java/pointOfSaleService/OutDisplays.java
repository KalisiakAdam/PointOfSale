package pointOfSaleService;

import dbManagement.NewConnection;
import dbManagement.Product;

import java.sql.*;
import java.util.*;

/**
 * Created by kalisiaczki on 15.03.2017.
 */

public class OutDisplays {

    public static List<Product> scannedProducts = new ArrayList<>();
    public static List<Product> allProducts = new ArrayList<>();

    public void isItInDatabase (String firstColumnName, String secondColumnName, String thirdColumnName){

        NewConnection newConnection = new NewConnection();
            String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                " FROM PRODUCTS";
        newConnection.sqlQueryToScan( sql,allProducts,firstColumnName,secondColumnName,thirdColumnName);
    }

    public  void scanProduct(String firstColumnName, String secondColumnName, String thirdColumnName, int scannedId) {

        if(allProducts.stream().anyMatch(s->s.getCode()==scannedId)) {

           NewConnection newConnection = new NewConnection();

                String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName +
                        " FROM PRODUCTS WHERE " + firstColumnName + " = " + scannedId;

                newConnection.sqlQueryToScanEach(sql,scannedProducts,firstColumnName,secondColumnName,thirdColumnName);

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
                System.out.println("\nTotal price of the products is: " + countPrice);
        }
    }
}



