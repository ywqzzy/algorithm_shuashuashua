package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class 最长不包含重复字符的子字符串 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for(int end = 0, start = 0; end < len; end++) {
            if(map.containsKey(s.charAt(end))) {
                start = Math.max(map.get(s.charAt(end)) + 1, start);
            }
            res = Math.max(res, end - start + 1);
            map.put(s.charAt(end), end);
        }
        return res;
    }
}
