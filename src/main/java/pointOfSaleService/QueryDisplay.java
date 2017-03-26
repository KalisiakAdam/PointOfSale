package pointOfSaleService;

import dbManagement.Product;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by kalisiaczki on 25.03.2017.
 */
public class QueryDisplay {

    public void queryToShowProduct(ResultSet rs, String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {

        int first = rs.getInt(firstColumnName);
        String second = rs.getString(secondColumnName);
        int third = rs.getInt(thirdColumnName);

        System.out.println(firstColumnName + ": " + first );
        System.out.println(secondColumnName + ": " + second );
        System.out.println(thirdColumnName + ": " + third );
    }

    public void qureryIsItInDB (ResultSet rs, List<Product> allProducts, String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {

        allProducts.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));
    }

    public void queryToScanProduct (ResultSet rs, List<Product> scannedProducts, String firstColumnName, String secondColumnName, String thirdColumnName) throws SQLException {

        scannedProducts.add(new Product(rs.getInt(firstColumnName), rs.getString(secondColumnName), rs.getInt(thirdColumnName)));

        int firstColumnScanedToDisplay = rs.getInt(firstColumnName);
        String secondCoulmnScanedToDisplay = rs.getString(secondColumnName);
        int thirdColumnScanedToDisplay = rs.getInt(thirdColumnName);

        System.out.println(firstColumnName + ": " + firstColumnScanedToDisplay);
        System.out.println(secondColumnName + ": " + secondCoulmnScanedToDisplay);
        System.out.println(thirdColumnName + ": " + thirdColumnScanedToDisplay);
    }
}
