
public class PalindromeModel {

    boolean isPalindrome;

    public PalindromeModel(){

    }

    public void isPal(String pal){
        isPalindrome = pal.equals(new StringBuilder(pal).reverse().toString());
    }

    public boolean isPalindrome() {
        return isPalindrome;
    }

}
