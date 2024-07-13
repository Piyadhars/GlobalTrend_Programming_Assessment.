class TrieNode {
    TrieNode[] childNode;
    boolean wordEnd;

    TrieNode() {
        childNode = new TrieNode[26];
        wordEnd = false;
    }
}

public class Main {
    TrieNode root;

    public Main() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.wordEnd = true;
    }

    public boolean search(String word) {
        TrieNode currentNode = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return currentNode.wordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode currentNode = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (currentNode.childNode[index] == null) {
                return false;
            }
            currentNode = currentNode.childNode[index];
        }
        return true;
    }

    public static void main(String[] args) {
        Main trie = new Main();
        String[] inputStrings = {"valur", "animal", "does", "gold", "dad", "ball"};
        for (String str : inputStrings) {
            trie.insert(str);
        }

        String[] searchQueryStrings = {"does", "gold", "bat"};
        for (String str : searchQueryStrings) {
            System.out.println("Query String: " + str);
            if (trie.search(str)) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }
        }

        String[] prefixQueryStrings = {"an", "ge", "ba"};
        for (String str : prefixQueryStrings) {
            System.out.println("Prefix Query String: " + str);
            if (trie.startsWith(str)) {
                System.out.println("Found");
            } else {
                System.out.println("Not Found");
            }
        }
    }
}
