import java.util.HashMap;
import java.util.Map;

public class lengthOfLongestSubstring3 {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null||s.length()==0)
            return 0;
        // 建立一个HashMap用来存放字符和位置信息
        Map<Character,Integer> map = new HashMap<Character, Integer>();
        int max = 0; // 用来记录最大值
        int count = 0; // 用来统计长度
        char[] c = s.toCharArray();
        for(int i =0;i<c.length;i++){
            if(!map.containsKey(c[i])){
                map.put(c[i], i);
                count++;
            }else {
                // 若map中已经包含该字符，分为两种情况讨论
                Integer index = map.get(c[i]);
                // 情况1：上次出现的该字符并不在当前所统计的最长字符串中，只需要更新位置信息。并且统计count++
                if(i-index>count){
                    count++;
                    map.put(c[i], i);
                    continue;
                }
                // 情况2：上次出现的该字符影响了当前最长不重复的子字符串
                // 则更新位置信息、max变量和count计数
                map.put(c[i], i);
                if(count>max){
                    max = count;
                }
                count = i - index;
            }
        }
        // 防止出现没有重复字符的情况，此时max = 0
        return max>count?max:count;
    }
}
