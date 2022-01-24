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
                String pass = input.substring(5, input.length() - 1);
                Rope newRope = new Rope(pass);
                ropes.add(newRope);
            } else if (check.equalsIgnoreCase("print")) {
                int i = Integer.parseInt(st.nextToken());
                Rope print = ropes.get(i-1);
                print.print(print.getRoot());
            } else if (check.equalsIgnoreCase("concat")) {
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                Rope firstRope = ropes.get(first - 1);
                Rope secondRope = ropes.get(second - 1);
                String firstStr = firstRope.getString(firstRope.getRoot());
                String secondStr = secondRope.getString(secondRope.getRoot());
                firstStr = firstStr.substring(0, firstStr.length() - 1);
                secondStr = secondStr.substring(0, secondStr.length() - 1);
                String result = firstStr.concat(secondStr);
                Rope resultRope = new Rope(result);
                ropes.add(first - 1, resultRope);
                ropes.remove(firstRope);
                ropes.remove(secondRope);
            } else if (check.equalsIgnoreCase("status")) {
                for (int i = 0; i < ropes.size(); i++) {
                    Rope temp = ropes.get(i);
                    System.out.print((i + 1) + ". ");
                    temp.status(temp.getRoot());
                    System.out.println();
                }
            } else if (check.equalsIgnoreCase("index")) {
                int num = Integer.parseInt(st.nextToken());
                Rope newRope = ropes.get(num);
                int i = Integer.parseInt(st.nextToken());
                System.out.println(newRope.index(newRope, i));
            } else if (check.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

//            List <String > strings = List.of("dd", "da" , "catch" , "bag" , "cat");
//            Trie trie = new Trie(strings);
//            System.out.println(trie.suggest("ca"));
         //   Trie t = new Trie();

        }
    }
}
