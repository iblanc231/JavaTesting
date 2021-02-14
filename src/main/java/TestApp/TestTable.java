package TestApp;

public class TestTable {
    
    private int id;
    private int val;
    private String word;

    public TestTable(int ID) {
        this.id = ID;
    }

    public TestTable(int ID, int val, String word) {
        this.id = ID;
        this.val = val;
        this.word = word;
    }

    public int getID() {
        return this.id;
    }

    public int getVal() {
        return this.val;
    }

    public String getWord() {
        return this.word;
    }

    public void setID(int i) {
        this.id = i;
    }

    public void setVal(int v) {
        this.val = v;
    }

    public void setWord(String w) {
        this.word = w;
    }

}
