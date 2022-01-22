public class Node {
    private int n;
    private String str;
    private Node right;
    private Node left;
    Node(String str, int n) {
        setN(n);
        setStr(str);
        setLeft(null);
        setRight(null);
    }
    public int getN() {
        return n;
    }
    public void setN(int n) {
        this.n = n;
    }
    public String getStr() {
        return str;
    }
    public void setStr(String str) {
        this.str = str;
    }
    public Node getRight() {
        return right;
    }
    public void setRight(Node right) {
        this.right = right;
    }
    public Node getLeft() {
        return left;
    }
    public void setLeft(Node left) {
        this.left = left;
    }
}