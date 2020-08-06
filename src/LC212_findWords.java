import java.util.ArrayList;
import java.util.List;

public class LC212_findWords {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String s : words) {
            trie.insert(s);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(i, j, board, res, trie.root);
            }
        }
        return res;
    }

    private void dfs(int row, int col, char[][] board, List<String> res, TrieNode node) {
        // 判断当前是不是合法位置
        if (row < 0 || col < 0 || row == board.length || col == board[0].length) {
            return;
        }
        char cur = board[row][col];
        // 当前字母是否被遍历过 或者 将要遍历的树中是否存在
        if (cur == '*' || node.links[cur - 'a'] == null) {
            return;
        }

        node = node.links[cur - 'a'];
        // 判断是否是一个单词的结束
        if (node.isEnd()) {
            res.add(node.word);
            // 将当前单词置为 null，防止重复加入
            node.word = null;
        }

        board[row][col] = '*';
        dfs(row - 1, col, board, res, node);
        dfs(row + 1, col, board, res, node);
        dfs(row, col - 1, board, res, node);
        dfs(row, col + 1, board, res, node);
        board[row][col] = cur;

    }

    class Trie {
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
            node.word = word;
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
    }

    class TrieNode {
        /**
         * 最多 R 个指向子结点的链接，其中每个链接对应字母表数据集中的一个字母。
         * 本文中假定 R 为 26，小写拉丁字母的数量。
         * 布尔字段，以指定节点是对应键的结尾还是只是键前缀。
         */
        private TrieNode[] links;

        private String word;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
            word = null;
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
