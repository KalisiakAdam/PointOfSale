package DBManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by kalisiaczki on 15.03.2017.
 */

public class H2JDBC {

    public static final String DB_DRIVER = "org.h2.Driver";
    public static final String DB_CONNECTION = "jdbc:h2:mem:PointOfSale.PointOfSale;DB_CLOSE_DELAY=-1;DATABASE_TO_UPPER=false";
    public static final String DB_USER ="admin";
    public static final String DB_PASSWORD = "admin";
}
