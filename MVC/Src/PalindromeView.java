
import java.util.Scanner;

public class PalindromeView {
	
    Scanner input = new Scanner(System.in);
    String userString;

    public PalindromeView() {
        System.out.println("Please enter in a word of your choice:");
        userString = input.nextLine();
    }

    public String getUserString() {
        return userString;
    }

    public void isPalindrome(){
        System.out.println("Yes! This is a Palindrome.");
    }

    public void notPalindrome(){
        System.out.println("No! This is not a Palindrome.");
    }

}
