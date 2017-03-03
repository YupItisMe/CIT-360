
public class Main {

    public static void main(String[] args) {

        PalindromeView view = new PalindromeView();

        PalindromeModel model = new PalindromeModel();

        PalindromeController controller = new PalindromeController(view, model);
    }
}
