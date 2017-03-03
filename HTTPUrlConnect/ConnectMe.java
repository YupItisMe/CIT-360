
import java.net.*;
import java.io.*;

//Some Nasty paths include making the URL NULL or putting nothing (including spaces) in between the quotes.
public class ConnectMe {

    private final String agent = "Mozilla/5.0";

    public static void main(String[] args) {

        
        ConnectMe connection = new ConnectMe();

        try {
            connection.start1();
            connection.start2();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void start1() throws Exception {

        URL yahoo = new URL("https://www.yahoo.com/");

        HttpURLConnection connection = (HttpURLConnection) yahoo.openConnection();
        connection.setDoOutput(true);
        connection.setRequestProperty("agent", agent);

        int code = connection.getResponseCode();

        System.out.println("\nSending response to: " + yahoo + "Response Code : " + code);
        System.out.println();
    }

    private void start2(){

        String yahoo = "https://www.yahoo.com/";
        URL url;

        try {
            url = new URL(yahoo);
            HttpURLConnection con1 = (HttpURLConnection)url.openConnection();
            print_content(con1);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void print_content(HttpURLConnection con1){
        if(con1 != null){

            try {
                System.out.println("Here is some YAHOO stuff");         
                BufferedReader buffer = new BufferedReader(new InputStreamReader(con1.getInputStream()));
                String s;

                while ((s = buffer.readLine()) != null){
                    System.out.println(s);
                }
                buffer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}