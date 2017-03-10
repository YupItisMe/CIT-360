
public class PalindromeModel {

    boolean palTest;

    public PalindromeModel(){

    }

    public void isPal(String pal){
        palTest = pal.equals(new StringBuilder(pal).reverse().toString());
    }

    public boolean palTest() {
        return palTest;
    }

}
