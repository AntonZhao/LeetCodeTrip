public class Trie {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        char[] letters = word.toCharArray();
        TrieNode node = root;
        for (char c : letters) {
            if (!node.containsKey(c)) {
                node.put(c, new TrieNode());
            }
            node = node.get(c);
        }
        node.setEnd();
    }

    // search a prefix or whole key in trie and
    // returns the node where search ends
    private TrieNode searchPrefix(String word) {
        char[] chars = word.toCharArray();
        TrieNode node = root;
        for (char c : chars) {
            if (node.containsKey(c)) {
                node = node.get(c);
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return searchPrefix(word) != null && searchPrefix(word).isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    public static void main(String[] args) {
        String[] ops = {"insert", "insert", "insert", "insert", "insert", "insert", "search", "search", "search", "search", "search", "search", "search", "search", "search", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith", "startsWith"};
        String[] contents = {"app", "apple", "beer", "add", "jam", "rental", "apps", "app", "ad", "applepie", "rest", "jan", "rent", "beer", "jam", "apps", "app", "ad", "applepie", "rest", "jan", "rent", "beer", "jam"};

        Trie trie = new Trie();

        System.out.println(ops.length + " " + contents.length);
        for (int i = 0; i < ops.length; i++) {
            String op = ops[i];
            String word = contents[i];
            System.out.println(i + " " + word);
            if (op == "insert") {
                trie.insert(word);
            } else if (op == "search") {
                System.out.println(trie.search(word));
            } else {
                System.out.println(trie.startsWith(word));
            }
        }

    }

    class TrieNode {
        /**
         * 最多 R 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
         * 本文中假定 R 为 26，小写拉丁字母的数量。
         * 布尔字段，以指定节点是对应键的结尾还是只是键前缀。
         */
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }
}
