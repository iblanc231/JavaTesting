package TestApp;

import java.sql.*;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        Database db = Database.getInstance();
        List<Object> list = new ArrayList<Object>();

        //Open database connection
        db.connect();
        
        //Test 1 - SELECT with ID condition
        list.add(0);
        db.query("Select * from testtable where id = ?",list);

        //Test 2 - SELECT with Word condition
        list.remove(0);
        list.add("hello");
        db.query("Select * from testtable where word = ?",list);

        //Test 3 - SELECT with no conditions
        db.query("select * from testtable",null);

        
        /*//Insert a new row
        query = "insert into testtable (ID, val) values (?, ?)";
        prep = conn.prepareStatement(query);
        prep.setInt(1,3);
        prep.setInt(2,420);
        prep.execute();


        //Select all
        query ="select * from testtable";
        stmt = conn.prepareStatement(query); 
        rs = stmt.executeQuery(query);*/
        
    }
}
