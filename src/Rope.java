import java.util.StringTokenizer;

public class Rope {
    private Node root;
    private String out = "";

    Rope(String input) {
        root = new Node(null, 0);
        newRope(input, root);
    }

    void print(Node node) {
        if (node == null)
            return;
        print(node.getLeft());
        System.out.println(node.getN() + " " + node.getStr());
        print(node.getRight());
    }

    void newRope(String input, Node root) {
        StringTokenizer st = new StringTokenizer(input);
        if (st.countTokens() > 2) {
            Node right = new Node(null, 0);
            root.setRight(right);
            Node left = new Node(null, 0);
            root.setLeft(left);
            int leftChild = (int) Math.ceil(st.countTokens() / 2.0);
            int rightChild = st.countTokens() - leftChild;
            String pass = st.nextToken();
            int length = pass.length();
            length++;
            for (int i = 1; i < leftChild; i++) {
                String temp = st.nextToken();
                length += temp.length();
                length++;
                pass = pass.concat(" " + temp);
            }
            newRope(pass, root.getLeft());
            root.setN(length);
            pass = st.nextToken();
            for (int i = 1; i < rightChild; i++) {
                pass = pass.concat(" " + st.nextToken());
            }
            newRope(pass, root.getRight());
        } else {
            if (st.countTokens() == 1) {
                String rightStr = st.nextToken();
                rightStr = rightStr.concat(" ");
                root.setN(rightStr.length());
                root.setStr(rightStr);
            } else if (st.countTokens() == 2) {
                String leftStr = st.nextToken();
                leftStr = leftStr.concat(" ");
                root.setN(leftStr.length());
                Node left = new Node(leftStr, leftStr.length());
                root.setLeft(left);
                String rightStr = st.nextToken();
                rightStr = rightStr.concat(" ");
                Node right = new Node(rightStr, rightStr.length());
                root.setRight(right);
            }
        }
    }

    public char index(Rope rope, int i) {
        Node tmp = rope.root;
        if (i <= tmp.getN()) {
            while (tmp.getStr() == null && i < tmp.getN())
                tmp = tmp.getLeft();
            if (tmp.getRight() == null && tmp.getLeft() == null)
                return tmp.getStr().charAt(i);

            if (tmp.getRight() != null) {
                while (tmp.getRight().getStr() == null && i > tmp.getN()) {
                    tmp = tmp.getRight();
                }
            }

            if (i < tmp.getN() && tmp.getStr() != null) {
                return tmp.getLeft().getStr().charAt(i);
            } else {
                return tmp.getRight().getStr().charAt(i - tmp.getN());
            }

        } else {

            while (tmp.getStr() == null && i >= tmp.getN()) {
                i -= tmp.getN();
                tmp = tmp.getRight();
            }

            if (tmp.getRight() == null && tmp.getLeft() == null)
                return tmp.getStr().charAt(i);


            if (tmp.getLeft() != null) {
                while (tmp.getLeft().getStr() == null && i <= tmp.getN()) {
                    tmp = tmp.getLeft();
                }

                if (i < tmp.getN() && tmp.getLeft().getStr() != null)
                    return tmp.getLeft().getStr().charAt(i);

            } else {
                return tmp.getRight().getStr().charAt(i - tmp.getN());
            }
        }
        return '-';
    }

    public Node getRoot() {
        return root;
    }

    String getString(Node node) {
        if (node == null) {
            return "";
        }
        getString(node.getLeft());
        if (node.getStr() != null) {
            out = out.concat(node.getStr());
        }
        getString(node.getRight());
        return out;
    }

    void status (Node node) {
        if (node == null) {
            return;
        }
        status(node.getLeft());
        if (node.getStr() != null) {
            System.out.print(node.getStr());
        }
        status(node.getRight());
    }
}