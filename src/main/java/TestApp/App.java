package TestApp;

import java.io.Console;

public class App {

    public static void main(String[] args) throws Exception {

        Database db = Database.getInstance();
        Console console = System.console();

        //Open database connection
        db.connect();
        
        TestTableAPI.getAllTestTables();

        int i = Integer.parseInt(new String(console.readLine("\n\nSearch for ID: ")));

        TestTable tt = TestTableAPI.getTestTableById(i);

        System.out.print("ID: " + tt.getID() + "\tValue: " + tt.getVal() + "\tWord: " + tt.getWord() + "\n");

        /*//Insert a new row
        query = "insert into testtable (ID, val) values (?, ?)";
        prep = conn.prepareStatement(query);
        prep.setInt(1,3);
        prep.setInt(2,420);
        prep.setString(3,"blaze it");
        prep.execute();*/
        
    }
}
