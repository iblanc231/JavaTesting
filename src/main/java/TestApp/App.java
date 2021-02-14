package TestApp;

import java.io.Console;
import java.util.*;

public class App {

    public static void main(String[] args) throws Exception {

        Database db = Database.getInstance();
        Console console = System.console();

        //Open database connection
        db.connect();
        
        //Query for all TestTables
        TestTableAPI.getAllTestTables();

        //Query for a TT by input ID
        int i = Integer.parseInt(new String(console.readLine("\n\nSearch for ID: ")));
        TestTable tt = TestTableAPI.getTestTableById(i);
        System.out.print("ID: " + tt.getID() + "\tValue: " + tt.getVal() + "\tWord: " + tt.getWord() + "\n");

        // //Insertion Testing
        // TestTable tt1 = new TestTable(1,2,"testing");
        // TestTable tt2 = new TestTable(2,3,"testing");
        // TestTable tt3 = new TestTable(3,69,"funny");

        // List<TestTable> tts = new ArrayList<TestTable>();
        // tts.add(tt2);
        // tts.add(tt3);

        // TestTableAPI.insertTestTable(tt);
        // TestTableAPI.insertTestTable(tts);

        //Close database connection
        db.close();
        
    }
}
