
public class ViewEx {

    // Constructor
    public ViewEx(ModelEx modelEx) {
        printText();
    }

    // Method printText
    public void printText() {
        System.out.print("P.S. TYPE \"exit\" TO EXIT THIS PROGRAM!!! \nPlease enter your " +
                "favorite number or type \"exit\": ");
    }

    // Method printText2
    public void printText2() {
        System.out.print("P.S. TYPE \"exit\" TO EXIT THIS PROGRAM!!! \nIf you want you can " +
                "enter another favorite number or type \"exit\": ");
    }

    // Method printNum
    public void printNum(int num) {
        System.out.println("\nYour favorite number is: " + num + "\n");
    }

}