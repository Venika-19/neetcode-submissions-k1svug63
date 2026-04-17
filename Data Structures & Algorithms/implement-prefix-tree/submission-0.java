public class TrieNode{

    TrieNode[] children = new TrieNode[26];
    boolean endOfWord = false;
}

class PrefixTree {
    
    private TrieNode root;
    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {

        TrieNode head = root;
        for(char c: word.toCharArray()){
            if(head.children[c - 'a'] == null){
                head.children[c - 'a'] = new TrieNode();
            }
            head = head.children[c - 'a'];
        }
        head.endOfWord = true;

    }

    public boolean search(String word) {

        TrieNode head = root;
        for(char c : word.toCharArray()){
            head = head.children[c - 'a'];
            if(head == null)
                return false;
        }

        if(head.endOfWord == true)
            return true;
        return false;
    }

    public boolean startsWith(String prefix) {

        TrieNode head = root;
        for(char c: prefix.toCharArray()){
            head = head.children[c - 'a'];
            if(head == null)
                return false;
        }
        return true;
    }
}
