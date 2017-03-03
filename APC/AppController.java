
import java.util.HashMap;


public class AppController {

    public static HashMap<String, Handler> favBooks = new HashMap<String, Handler>();

    public AppController(){
        favBooks.put("f", new Fantasy());
        favBooks.put("r", new Romance());
        favBooks.put("s", new SciFi());
    }

    public void determineType(String type){

        Handler request = favBooks.get(type);
        request.list();

    }

}
