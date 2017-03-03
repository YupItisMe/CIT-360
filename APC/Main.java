
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String type;

        AppController controller = new AppController();

        Scanner input = new Scanner(System.in);

        System.out.println("*****Joshua's Collection of Fine Books*****");

        System.out.println("Woudl you like to see?");
        System.out.println("F = Fantasy");
        System.out.println("R = Romance");
        System.out.println("S = Science Fiction");

//        take input from user
        type = input.nextLine().toLowerCase();

//        send it to controller
        controller.determineType(type);



    }
}
