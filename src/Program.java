import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Rope> ropes = new ArrayList<>();
        while (true) {
            String input = in.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String check = st.nextToken();
            if (check.equalsIgnoreCase("new")) {
                String pass = input.substring(5,input.length()-1);
                Rope newRope = new Rope(pass);
                ropes.add(newRope);
            }
            else if (check.equalsIgnoreCase("status")) {
                for (int i=0; i<ropes.size(); i++) {
                    Rope temp = ropes.get(i);
                    System.out.print((i+1) + ". ");
                    temp.status(temp.getRoot());
                    System.out.println();
                }
            }
            else if (check.equalsIgnoreCase("exit")) {
                break;
            }
        }
    }
}
