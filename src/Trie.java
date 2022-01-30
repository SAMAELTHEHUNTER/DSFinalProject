import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Trie {
    Map<Character, Trie> childs;
    char ch;
    boolean isWord;

    public Trie() {
        childs = new HashMap<>();
    }

    public Trie(char c) {
        this.ch = c;
        childs = new HashMap<>();
    }

    public void insert(String word) {
        if (word == null || word.isEmpty())
            return;
        char firstChar = word.charAt(0);
        Trie child = childs.get(firstChar);
        if (child == null) {
            child = new Trie(firstChar);
            childs.put(firstChar, child);
        }

        if (word.length() > 1)
            child.insert(word.substring(1));
        else
            child.isWord = true;
    }


    Trie root;

    public Trie(List<String> words) {
        root = new Trie();
        for (String word : words)
            root.insert(word);
    }

    public void suggestHelper(Trie root, List<String> list, StringBuffer current) {
        if (root.isWord) {
            list.add(current.toString());
        }

        if (root.childs == null || root.childs.isEmpty())
            return;

        for (Trie child : root.childs.values()) {
            suggestHelper(child, list, current.append(child.ch));
            current.setLength(current.length() - 1);
        }
    }

    public List<String> suggest(String prefix) {
        List<String> list = new ArrayList<>();
        Trie node = root;
        StringBuffer curr = new StringBuffer();
        for (char ch : prefix.toCharArray()) {
            node = node.childs.get(ch);
            if (node == null)
                return list;
            curr.append(ch);
        }
        suggestHelper(node, list, curr);
        return list;
    }
}



