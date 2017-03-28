import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ControllerEx {

    // Reference to the view and the model
    private ModelEx modelEx;
    private ViewEx viewEx;

    // Constructor
    public ControllerEx (ModelEx modelEx, ViewEx viewEx) {
        this.modelEx = modelEx;
        this.viewEx = viewEx;
    }

    // Method run
    public void run() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String exit = reader.readLine().toLowerCase();
            if (exit.equals("exit")) {
                break;
            }
            int num = Integer.parseInt(exit);
            int number = num;
  
            number = modelEx.yourNum();
            viewEx.printNum(num);
            viewEx.printText2();
        }
    }

}