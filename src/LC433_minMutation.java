import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class LC433_minMutation {
    public int minMutation(String start, String end, String[] bank) {
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        char[] mm = {'A', 'C', 'G', 'T'};
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        set.remove(start);
        int step = 0;
        while (!queue.isEmpty()) {
            step++;
            for (int count = queue.size(); count > 0; --count) {
                char[] tempStringChars = queue.remove().toCharArray();
                for (int i = 0, len = tempStringChars.length; i < len; i++) {
                    char oldChar = tempStringChars[i];
                    for (int j = 0; j < 4; j++) {
                        tempStringChars[i] = mm[j];
                        String newGene = new String(tempStringChars);
                        if (end.equals(newGene)) {
                            return step;
                        } else if (set.contains(newGene)) {
                            set.remove(newGene);
                            queue.offer(newGene);
                        }
                    }
                    tempStringChars[i] = oldChar;
                }
            }
        }
        return -1;
    }
}
