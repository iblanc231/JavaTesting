package TestApp;

import java.sql.*;
import java.util.*;

public class TestTableAPI {
    
    private static Database db = Database.getInstance();

    public static void getAllTestTables() throws SQLException {

        String query = "SELECT * FROM testtable";

        ResultSet rs = db.query(query);

        //parse ResultSet into TestTable objects
        while (rs.next()) {
            System.out.print("ID: " + rs.getInt("ID") + "\tValue: " + rs.getInt("val") + "\tWord: " + rs.getString("word") + "\n");
        }
    }

    public static TestTable getTestTableById(int ID) throws SQLException{

        String query = "SELECT * FROM testtable WHERE ID = ?";

        List<Object> params = new ArrayList<Object>();
        params.add(ID);

        ResultSet rs = db.query(query,params);

        //parse resultset into TestTable objects
        rs.next();
        TestTable result = new TestTable(ID);
        result.setVal(rs.getInt("val"));
        result.setWord(rs.getString("word"));

        return result;

    }

    public static boolean insertTestTable(TestTable tt) {
        
        String query = "INSERT INTO testtable (ID, val, word) VALUES (?,?,?)";
        List<Object> params = new ArrayList<Object>();

        params.add(tt.getID());
        params.add(tt.getVal());
        params.add(tt.getWord());

        try {

            int x = db.insert(query, params);
            return x == 1;

        } 
        catch (SQLException e) {

            System.out.println(e);
            return false;

        }

        
    }

    public static boolean insertTestTable(List<TestTable> tts) {

        String query = "INSERT INTO testtable (ID, val, word) VALUES (?,?,?)";
        List<Object> params = new ArrayList<Object>();

        try {

            for (TestTable tt : tts) {
                params.clear();
                params.add(tt.getID());
                params.add(tt.getVal());
                params.add(tt.getWord());
                db.insert(query,params);
            }

            return true;

        } catch (SQLException e)
        {
            return false;
        }


    }

}
