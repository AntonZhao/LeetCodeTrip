import java.sql.Array;
import java.util.*;

public class LC127_ladderLength {
    //    双向 BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordList_ = new HashSet<>(wordList);

        // 从beginWord和endWord分别向外扩散
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);

        int len = 1;
        int strLen = beginWord.length();
        // 被访问过的节点
        HashSet<String> visited = new HashSet<>();

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            // 每次只扩散一个set，优先扩散小的，也就是beginSet， 所以有了下面的互换
            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }
            // temp是新扩展出来的set
            Set<String> temp = new HashSet<>();
            for (String word : beginSet) {
                char[] chs = word.toCharArray();
                for (int i = 0; i < chs.length; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chs[i];
                        chs[i] = c;
                        String newWord = String.valueOf(chs);

                        if (endSet.contains(newWord)) {
                            return len + 1;
                        }
                        if (!visited.contains(newWord) && wordList_.contains(newWord)) {
                            temp.add(newWord);
                            visited.add(newWord);
                        }
                        chs[i] = old;
                    }
                }
            }
            beginSet = temp;
            len++;
        }

        return 0;
    }

    //    单向 BFS
    public int ladderLength_BFS(String beginWord, String endWord, List<String> wordList) {
        // 把字典里的词放进set，如果包含endWord则直接返回0
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0;

        // 宽度优先，需要使用队列
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // beginWord已经入队，从set里删除
        set.remove(beginWord);
        // 记录步数， 所有词长度一样
        int step = 0;
        int LEN = beginWord.length();

        //只要queue不为空，就搜
        while (!queue.isEmpty()) {
            step++;
            // 记录当前queue的size，因为循环里会执行入队操作，大小会变
            // 当亲仅循环这一轮的
            int curQueueSize = queue.size();
            for (int i = 0; i < curQueueSize; i++) {
                // 把队头的词取出来
                char[] chars = queue.poll().toCharArray();
                for (int j = 0; j < LEN; j++) {
                    // 对这个词，每一位都换成其他字母，看看是否在set里
                    char temp = chars[j];

                    for (int k = 0; k < 26; k++) {
                        chars[j] = (char) ('a' + k);
                        String newWord = new String(chars);
                        // set里没有，直接过
                        if (!set.contains(newWord)) {
                            continue;
                        }
                        if (newWord.equals(endWord)) {
                            // 找到了，返回步数
                            System.out.println(newWord + " " + step);
                            return step + 1;
                        } else {
                            // 不是endWord，加入队列，从set里删除
                            queue.offer(newWord);
                            System.out.println(newWord + " " + step);
                            set.remove(newWord);
                        }
                    }

                    chars[j] = temp;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        LC127_ladderLength ll = new LC127_ladderLength();

        String[] ss = {"hot", "dot", "dog", "lot", "log", "cog"};
//        String[] ss = {"a", "b", "c"};

        List<String> list = Arrays.asList(ss);
//        System.out.println(ll.ladderLength("hit", "cog", list));
        System.out.println(ll.ladderLength("hit", "cog", list));

    }
}
