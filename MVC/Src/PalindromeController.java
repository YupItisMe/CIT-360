
public class PalindromeController {

    public PalindromeController(PalindromeView view, PalindromeModel model) {

        model.isPal(view.getUserString());

        if(model.isPalindrome()){
            view.isPalindrome();
        }else{
            view.notPalindrome();
        }

    }

}
