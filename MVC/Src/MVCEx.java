
import java.io.IOException;

public class MVCEx {

    public static void main(String[] args) throws IOException {
        // model
        ModelEx modelEx = new ModelEx();
        // view
        ViewEx viewEx = new ViewEx(modelEx);
        // Pass to Controller
        new ControllerEx(modelEx, viewEx).run();

       
    }

}