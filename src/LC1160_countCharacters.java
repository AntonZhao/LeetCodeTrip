import java.util.HashMap;
import java.util.Map;

public class LC1160_countCharacters {
    public int countCharacters(String[] words, String chars) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : chars.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int res = 0;
        for(String word : words) {
            Map<Character, Integer> wordMap = new HashMap<>();
            for(char c : word.toCharArray()) {
                map.put(c, wordMap.getOrDefault(c, 0) + 1);
            }
            boolean flag = true;
            for(Character c : wordMap.keySet()) {
                if (!map.containsKey(c)) {
                    flag = false;
                    break;
                }
                if (map.get(c) < wordMap.get(c)) {
                    flag = false;
                    break;
                }
            }
            res += flag == true ? word.length() : 0;
            System.out.println(flag + "  " + word);
        }
        return res;
    }

    public static void main(String[] args) {
        LC1160_countCharacters ll = new LC1160_countCharacters();
        String[] words = {"cat","bt","hat","tree"};
        System.out.println(ll.countCharacters(words, "atach"));
    }
}
