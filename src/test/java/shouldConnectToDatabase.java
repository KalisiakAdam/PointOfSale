import pointOfSaleService.Information;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by kalisiaczki on 18.03.2017.
 */

public class shouldConnectToDatabase {

    Information information = new Information();

    @Before
    public void setup(){
        information.makeDBConnection();
    }

    @Test
    public void connectionTest() throws SQLException {

        Statement statement = information.makeDBConnection().createStatement();
        statement.execute("CREATE TABLE PRODUCTS (id INT )");
        statement.close();
    }

    @After
    public void closeDown() throws Exception{
         information.makeDBConnection().close();
    }
}
