package dbManagement;

import pointOfSaleService.Information;
import pointOfSaleService.QueryDisplay;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by kalisiaczki on 23.03.2017.
 */
public class NewConnection  {

    Information information = new Information();
    Connection connection = information.makeDBConnection();
    Statement statement = null;


    public void sqlQuery (String query){

        try {
            statement = connection.createStatement();
            statement.executeUpdate(query);
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
    }

    public void sqlQueryWithToShowParam(String query, String firstColumnName, String secondColumnName, String thirdColumnName){

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){

                QueryDisplay queryDisplay = new QueryDisplay();
                queryDisplay.queryToShowProduct(rs,firstColumnName,secondColumnName,thirdColumnName);
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

    public void sqlQueryToScan (String query, List<Product> allProduct, String firstColumnName, String secondColumnName, String thirdColumnName){

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){

                QueryDisplay queryDisplay = new QueryDisplay();
                queryDisplay.qureryIsItInDB(rs,allProduct,firstColumnName,secondColumnName,thirdColumnName);

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

    public void sqlQueryToScanEach (String query, List<Product> allProduct, String firstColumnName, String secondColumnName, String thirdColumnName){

        try{
            statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);

            while(rs.next()){

                QueryDisplay queryDisplay = new QueryDisplay();
                queryDisplay.queryToScanProduct(rs,allProduct,firstColumnName,secondColumnName,thirdColumnName);
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



