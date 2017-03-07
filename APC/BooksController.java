
import java.util.HashMap;

public class BooksController {
    public static HashMap<Integer, Handler> books = new HashMap<Integer, Handler>();

    public static void put(int book){
    	books.put(1, new Fantasy());
    	books.put(2, new Romance());
    	books.put(3, new ScienceFiction());

        Handler handler = books.get(book);
        handler.execute(book);
    }
}