package TestApp;

import java.io.Console;
import java.sql.*;
import java.util.*;

public class Database {
    
    private static Database INSTANCE;       //Singleton instance for the Database
    private Connection con;                 //connection to MySQL database
    private ResultSet rs;                   //Results from Select queries to be parsed
    private Statement stmt;
    private PreparedStatement ps;

    //Constructor is private because this is a Singleton object.
    private Database() {} 

    public static Database getInstance() {
        
        //if DB instance does not exist, create it (Singleton)
        if (INSTANCE == null)
            INSTANCE = new Database();

        return INSTANCE;
    }

    public void connect() {

        //Create scanner and console objects for inputs
        Scanner scn = new Scanner(System.in);
        Console console = System.console();

        //Input username
        System.out.print("Username: ");
        String username = scn.nextLine();

        //Input password
        String password = new String(console.readPassword("Password: "));

        //Input database name
        System.out.print("Database name: ");
        String dbURL = "jdbc:mysql://localhost:3306/" + scn.nextLine();
        
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

    public void insert(String query) throws SQLException {

    }

    public void query(String query, List<Object> params) throws SQLException {

        ps = con.prepareStatement(query);

        if (params != null) {
            for (int i = 0; i < params.size(); i++) {

                if (params.get(i) instanceof Integer)
                    ps.setInt(i + 1, (Integer) params.get(i));

                if (params.get(i) instanceof String)
                    ps.setString(i + 1, (String) params.get(i));
            }
        }

        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getInt("val"));
            System.out.println(rs.getString("word"));
        }

    }

    public void getValue(int id) throws SQLException {
        String query = "Select * from testtable where id = ?";

        ps = con.prepareStatement(query);
        ps.setInt(1,id);
        
        rs = ps.executeQuery();

        while (rs.next()) {
            System.out.println(rs.getInt("ID"));
            System.out.println(rs.getInt("val"));
        }

    }

}
