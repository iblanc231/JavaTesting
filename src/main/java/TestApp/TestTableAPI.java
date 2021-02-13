package TestApp;

import java.sql.*;
import java.util.*;

public class TestTableAPI {
    
    private static Database db = Database.getInstance();

    public static void getAllTestTables() throws SQLException {

        String query = "select * from testtable";

        ResultSet rs = db.query(query);

        //parse ResultSet into TestTable objects
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt("ID") + "\tValue: " + rs.getInt("val") + "\tWord: " + rs.getString("word") + "\n");
        }
    }

    public static TestTable getTestTableById(int ID) throws SQLException{

        String query = "select * from testtable where id = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(ID);

        ResultSet rs = db.query(query,params);

        //parse resultset into TestTable objects
        rs.next();
        TestTable result = new TestTable();
        result.setID(ID);
        result.setVal(rs.getInt("val"));
        result.setWord(rs.getString("word"));

        return result;

    }

    public static void insertTestTable(TestTable tt) {
        
    }

}
