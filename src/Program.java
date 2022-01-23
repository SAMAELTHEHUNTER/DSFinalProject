import java.io.*;
import java.util.*;

public class Program {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            ArrayList<Rope> ropes = new ArrayList<>();
            String input = in.readLine();
            StringTokenizer st = new StringTokenizer(input);
            String check = st.nextToken();
            if (check.equalsIgnoreCase("new")) {
                String pass = input.substring(5, input.length() - 1);
                Rope newRope = new Rope(pass);
                newRope.print(newRope.getRoot());
                ropes.add(newRope);
            } else if (check.equalsIgnoreCase("print")) {
                Rope print = ropes.get(0);
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
            } else if (check.equalsIgnoreCase("index")) {
                Rope newRope = new Rope("I_ am_ rope_ data_ structure");
                Scanner scanner = new Scanner(System.in);
//                int num = Integer.parseInt(st.nextToken());
                int ind = scanner.nextInt();
                System.out.println(newRope.index(newRope, ind));
            } else if (check.equalsIgnoreCase("exit")) {
                System.exit(0);
            }

            List <String > strings = List.of("dd", "da" , "catch" , "bag" , "cat");
            Trie trie = new Trie(strings);
            System.out.println(trie.suggest("ca"));
         //   Trie t = new Trie();

        }
    }
}
