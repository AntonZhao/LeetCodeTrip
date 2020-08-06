import java.util.*;

public class LC820_minimumLengthEncoding {
    /**
     * 极简之法
     * 时间复杂度：O(NK^2) substring的时间是O(K)
     * 空间复杂度：
     */
    public int minimumLengthEncoding(String[] words) {
        Set<String> set = new HashSet<>(Arrays.asList(words));
        for (String word : words) {
            for (int i = 1; i < word.length(); i++) {
                set.remove(word.substring(i));
            }
        }
        int res = 0;
        for (String s : set) {
            res += s.length() + 1;
        }
        return res;
    }

    /**
     * 构建trie树
     */
    public int minimumLengthEncoding_trie(String[] words) {
        TrieNode root = new TrieNode(0);
        Set<TrieNode> leavesSet = new HashSet<>();
        for (String word : words) {
            TrieNode node = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                char ch = word.charAt(i);
                if (!node.containsKey(ch)) {
                    node.put(ch, new TrieNode(word.length() - i));
                }
                node = node.get(ch);
                if (i == 0) {
                    leavesSet.add(node);
                }
            }
        }
        int res = 0;
        for (TrieNode node : leavesSet) {
            res += node.next == false ? node.depth + 1 : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        LC820_minimumLengthEncoding ll = new LC820_minimumLengthEncoding();
//        String[] words = {"time", "me", "bell"};
        String[] words = {"time", "time", "time"};
        System.out.println(ll.minimumLengthEncoding_trie(words));
    }


    class TrieNode {
        private TrieNode[] links;
        private int depth;
        private int R = 26;
        private boolean next = false;

        public TrieNode(int depth) {
            this.links = new TrieNode[R];
            this.depth = depth;
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
            next = true;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }
    }
}
