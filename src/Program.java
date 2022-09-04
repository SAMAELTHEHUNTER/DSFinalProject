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
                Rope print = ropes.get(i - 1);
                print.status(print.getRoot());
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
                Rope newRope = ropes.get(num - 1);
                int i = Integer.parseInt(st.nextToken());
                System.out.println(newRope.index(newRope, i));
            } else if (check.equalsIgnoreCase("insert")) {
                int firstI = Integer.parseInt(st.nextToken());
                Rope first = ropes.get(firstI - 1);
                int index = Integer.parseInt(st.nextToken());
                int secondI = Integer.parseInt(st.nextToken());
                Rope second = ropes.get(secondI - 1);
                String firstStr = first.getString(first.getRoot());
                String secondStr = second.getString(second.getRoot());
                firstStr = firstStr.substring(0, firstStr.length() - 1);
                secondStr = secondStr.substring(0, secondStr.length() - 1);
                String firstStr1 = firstStr.substring(0, index + 1);
                String firstStr2 = firstStr.substring(index + 1, firstStr.length());
                String result = firstStr1 + secondStr + firstStr2;
                Rope newRope = new Rope(result);
                ropes.add(firstI - 1, newRope);
                ropes.remove(first);
                ropes.remove(second);
            } else if (check.equalsIgnoreCase("split")) {
                int i = Integer.parseInt(st.nextToken());
                Rope target = ropes.get(i - 1);
                String targetStr = target.getString(target.getRoot());
                int index = Integer.parseInt(st.nextToken());
                String targetStr1 = targetStr.substring(0, index + 1);
                String targetStr2 = targetStr.substring(index + 1, targetStr.length());
                Rope result1 = new Rope(targetStr1);
                Rope result2 = new Rope(targetStr2);
                ropes.add(i - 1, result1);
                ropes.add(i, result2);
                ropes.remove(target);
            } else if (check.equalsIgnoreCase("delete")) {
                int i = Integer.parseInt(st.nextToken());
                Rope target = ropes.get(i - 1);
                String targetStr = target.getString(target.getRoot());
                int index1 = Integer.parseInt(st.nextToken());
                int index2 = Integer.parseInt(st.nextToken());
                String targetStr1 = targetStr.substring(0, index1);
                String targetStr2 = targetStr.substring(index2, targetStr.length());
                String result = targetStr1.concat(targetStr2);
                Rope resultRope = new Rope(result);
                ropes.add(i - 1, resultRope);
                ropes.remove(target);
            } else if (check.equalsIgnoreCase("exit")) {
                System.exit(0);

            } else if (check.equalsIgnoreCase("autocomplete")) {
                BufferedReader reader;
                List<String> list = new ArrayList<>();
                List<String> newList;
                try {
                    reader = new BufferedReader(new FileReader("F:\\barname nevisi\\termProjDS\\DSFinalProject\\src\\input.txt"));
                    String line = reader.readLine();
                    while (line != null) {
                        list.add(line);
                        line = reader.readLine();
                    }
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }

                Trie trie = new Trie(list);
                String prefix = st.nextToken();
                newList = trie.suggest(prefix);
                if (newList.size() >= 3) {
                    System.out.println("1." + newList.get(0));
                    System.out.println("2." + newList.get(1));
                    System.out.println("3." + newList.get(2));
                } else if (newList.size() == 2) {
                    System.out.println("1." + newList.get(0));
                    System.out.println("2." + newList.get(1));
                } else if (newList.size() == 1) {
                    System.out.println("1." + newList.get(0));
                } else {
                    System.err.println("Nothing found !");
                }

                int num = Integer.parseInt(in.readLine());

                switch (num) {
                    case 1:
                        Rope newRope = new Rope(newList.get(0));
                        ropes.add(newRope);
                        System.out.println("Successful !");
                        break;

                    case 2:
                        Rope newRope1 = new Rope(newList.get(1));
                        ropes.add(newRope1);
                        System.out.println("Successful !");
                        break;

                    case 3:
                        Rope newRope2 = new Rope(newList.get(2));
                        ropes.add(newRope2);
                        System.out.println("Successful !");
                        break;

                    default:
                        System.err.println("Error !!!");
                }

            }
        }
    }
}
