import java.util.StringTokenizer;

public class Rope {
    private Node root;
    Rope(String input) {
        root = new Node(null, 0);
        newRope(input, root);
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
            for (int i=1; i<leftChild; i++) {
                String temp = st.nextToken();
                length += temp.length();
                pass = pass.concat(" "+temp);
            }
            newRope(pass, root.getLeft());
            root.setN(length);
            pass = st.nextToken();
            for (int i=1; i<rightChild; i++) {
                pass = pass.concat(" "+st.nextToken());
            }
            newRope(pass, root.getRight());
        }
        else {
            if (st.countTokens()==1) {
                String rightStr = st.nextToken();
                root.setN(rightStr.length());
                root.setStr(rightStr);
            }
            else {
                String leftStr = st.nextToken();
                root.setN(leftStr.length());
                Node left = new Node(leftStr, leftStr.length());
                root.setLeft(left);
                String rightStr = st.nextToken();
                Node right = new Node(rightStr, rightStr.length());
                root.setRight(right);
            }
        }
    }

    void status (Node node) {
        if (node == null) {
            return;
        }
        status(node.getLeft());
        if (node.getStr() != null) {
            System.out.print(node.getStr() + " ");
        }
        status(node.getRight());
    }

    public Node getRoot() {
        return root;
    }
}