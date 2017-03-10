
public class PalindromeController {

    public PalindromeController(PalindromeView view, PalindromeModel model) {

        model.isPal(view.getUserString());

        if(model.palTest()){ // the two are seperated and the controller plays the middle man.
            view.isPalindrome();
        }else{
            view.notPalindrome();
        }

    }

}
