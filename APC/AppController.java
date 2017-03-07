
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppController {

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        BooksController controller = new BooksController();

        try {
            System.out.println("Books Books Books!");
            System.out.println("What kind of book would you like?");
            System.out.println("1 for Fantasy");
            System.out.println("2 for Romance");
            System.out.println("3 for Science Fiction");

            int book = Integer.parseInt(read.readLine());
            controller.put(book);
        }
        catch (Exception e){
            System.out.println("Please select one of the listed Options!");
            int book = Integer.parseInt(read.readLine());
            controller.put(book);
        }
    }
}