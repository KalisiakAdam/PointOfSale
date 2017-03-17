package DBManagement;

import PointOfSaleService.Information;

import java.sql.*;

/**
 * Created by kalisiaczki on 16.03.2017.
 */
public class SystemManagment {


    public static void createTable(String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {

        Connection connection = Information.makeDBConnection();
        Statement statement = null;

        try {

            statement = connection.createStatement();
            String createQuery = "CREATE TABLE PRODUCTS " + "( " + firstColumnName +" INTEGER primary key, " + secondColumnName + " varchar(255), " + thirdColumnName + " INTEGER)";

            statement.executeUpdate(createQuery);
            System.out.println("Create table of products");
            statement.close();
            connection.close();
        } catch (SQLException se) {
            se.printStackTrace();
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

        System.out.println("Table with following column has been created: " + firstColumnName + ", " + secondColumnName + ", " +thirdColumnName +"\n");
    }

    public static void insertProduct(int id, String name, int price , String firstColumnName, String secondColumnName, String thirdColumnName){
        Connection connection = Information.makeDBConnection();
        Statement statement = null;

            try {
                statement = connection.createStatement();

                String sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")" +
                        " VALUES " + "(" + id + ", '" + name + "', " + price + ")";
                statement.executeUpdate(sql);

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

    public static void insertSample (String firstColumnName, String secondColumnName, String thirdColumnName){

        Connection connection = Information.makeDBConnection();
        Statement statement = null;

            try{
                statement = connection.createStatement();

                String sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                    " VALUES " + "(" + 1357 + ", 'IPAD', " + 2000 + ")";
                statement.executeUpdate(sql);
                   sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                    " VALUES " + "(" + 2468 + ", 'IMAC', " + 8000 + ")";
                statement.executeUpdate(sql);
                sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                    " VALUES " + "(" + 1235 + ", 'IPHONE', " + 3000 + ")";
                statement.executeUpdate(sql);

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

    public static void showProducts(String firstColumnName, String secondColumnName, String thirdColumnName){
        Connection connection = Information.makeDBConnection();
        Statement statement = null;

        try{
            statement = connection.createStatement();

            String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName  +
                    " FROM PRODUCTS " ;
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                int first = rs.getInt(firstColumnName);
                String second = rs.getString(secondColumnName);
                int third = rs.getInt(thirdColumnName);

                System.out.println(firstColumnName + ": " + first );
                System.out.println(secondColumnName + ": " + second );
                System.out.println(thirdColumnName + ": " + third );

            }
            rs.close();

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

}
