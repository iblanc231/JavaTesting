package TestApp;

import java.io.Console;
import java.sql.*;
import java.util.*;

public class Database {
    
    private static Database INSTANCE;       //Singleton instance for the Database
    private Connection con;                 //connection to MySQL database
    private PreparedStatement ps;

    //Constructor is private because this is a Singleton object.
    private Database() {} 

    public static Database getInstance() {
        
        //if DB instance does not exist, create it (Singleton)
        if (INSTANCE == null)
            INSTANCE = new Database();

        return INSTANCE;
    }

    public void connect() throws SQLException {

        //Create console objects for inputs
        Console console = System.console();

        //Input username, password, and db name
        String username = new String(console.readLine("Username: "));
        String password = new String(console.readPassword("Password: "));
        String dbURL = "jdbc:mysql://localhost:3306/" + console.readLine("Database Name: ");
        
        //Try connection to database
        try {
            
            //Create connection and print success if successful
            con = DriverManager.getConnection(dbURL, username, password);
            System.out.println("Success");

        } catch (Exception e) {

            //If exception, print Failure and exception message
            System.out.println("Failure");
            System.out.println(e);

        }

    }

    public ResultSet query(String query) throws SQLException {

        //Prepare and execute statement. Return result set.
        ps = con.prepareStatement(query);
        return ps.executeQuery();

    }

    public ResultSet query(String query, List<Object> params) throws SQLException {

        //Prepare the query in the Prepared Statement
        ps = con.prepareStatement(query);

        //Prepare the parameters for the query (Where clause)
        if (params != null) {
            for (int i = 0; i < params.size(); i++) {

                if (params.get(i) instanceof Integer)
                    ps.setInt(i + 1, (Integer) params.get(i));

                if (params.get(i) instanceof String)
                    ps.setString(i + 1, (String) params.get(i));

            }
        }

        //Execute query and return result set
        return ps.executeQuery();


    }

    public void insert() {
        
    }

}
