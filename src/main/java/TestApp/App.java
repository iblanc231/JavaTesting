package TestApp;

import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        Database db = Database.getInstance();
        Scanner scn = new Scanner(System.in);

        //Open database connection
        db.connect();
        
        TestTableAPI.getAllTestTables();

        System.out.print("\n\nSearch for ID: ");
        String s = scn.nextLine();
        int i = Integer.parseInt(s);

        TestTable tt = TestTableAPI.getTestTableById(i);

        System.out.print("ID: " + tt.getID() + "\tValue: " + tt.getVal() + "\tWord: " + tt.getWord() + "\n");

        /*//Insert a new row
        query = "insert into testtable (ID, val) values (?, ?)";
        prep = conn.prepareStatement(query);
        prep.setInt(1,3);
        prep.setInt(2,420);
        prep.execute();*/
        
    }
}
