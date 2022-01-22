public class Rope {
    private Node root;
    private int size = 0;
    private int power = 1;
    Rope() {
        Node rope = new Node(null, 0);
    }

    void Status() {

    }

    void Insert(String str) {
        char[] array = str.toCharArray();
        Node newNode = new Node(str, array.length);
        Node current = root;
        Node last = root;
        int i = 0;
        while (true) {
            i++;
            if (size < Math.pow(2,i) && size > Math.pow(2,i-1)) {

            }
        }
    }

}