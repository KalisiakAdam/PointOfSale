package dbManagement;


import pointOfSaleService.QueryDisplay;

import java.sql.*;

/**
 * Created by kalisiaczki on 16.03.2017.
 */
public class SystemManagment {

    public void createTable(String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {
        NewConnection newConnection = new NewConnection();
            String createQuery = "CREATE TABLE PRODUCTS " + "( " + firstColumnName +" INTEGER primary key, " + secondColumnName + " varchar(255), " + thirdColumnName + " INTEGER)";

        newConnection.sqlQuery(createQuery);

            System.out.println("\nTable with following column has been created: " + firstColumnName + ", " + secondColumnName + ", " +thirdColumnName +"\n");
    }

    public void insertProduct(int id, String name, int price , String firstColumnName, String secondColumnName, String thirdColumnName){
        NewConnection newConnection = new NewConnection();
            String sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")" +
                " VALUES " + "(" + id + ", '" + name + "', " + price + ")";
        newConnection.sqlQuery(sql);
    }

    public void insertSample (String firstColumnName, String secondColumnName, String thirdColumnName){
        NewConnection newConnection = new NewConnection();
        NewConnection newConnection1 = new NewConnection();
        NewConnection newConnection2 = new NewConnection();
            String sql = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                " VALUES " + "(" + 1357 + ", 'IPAD', " + 2000 + ")";
        newConnection.sqlQuery(sql);

            String sql1 = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                " VALUES " + "(" + 2468 + ", 'IMAC', " + 8000 + ")";
        newConnection1.sqlQuery(sql1);

            String sql2 = "INSERT INTO PRODUCTS (" + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName + ")"  +
                " VALUES " + "(" + 1235 + ", 'IPHONE', " + 3000 + ")";
        newConnection2.sqlQuery(sql2);
    }

    public void showProducts(String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {

        NewConnection newConnection = new NewConnection();

            String sql = "SELECT " + firstColumnName + ", " + secondColumnName + ", " + thirdColumnName  +
                " FROM PRODUCTS " ;
        newConnection.sqlQueryWithToShowParam( sql,firstColumnName,secondColumnName,thirdColumnName);
    }
}
