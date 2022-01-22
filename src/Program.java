import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            ArrayList<Rope> ropes = new ArrayList<Rope>();
            String input = in.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String check = st.nextToken();
            if (check.equalsIgnoreCase("new")) {
                String pass = input.substring(5,input.length()-1);
                Rope newRope = new Rope(pass);
                newRope.print(newRope.getRoot());
                ropes.add(newRope);
            }
            else if (check.equalsIgnoreCase("print")) {
                Rope print = ropes.get(0);
                print.print(print.getRoot());
            }
            else if (check.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}
