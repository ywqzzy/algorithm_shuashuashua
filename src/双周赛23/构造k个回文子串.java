package 双周赛23;

import java.util.HashMap;
import java.util.Map;

public class 构造k个回文子串 {
    public boolean canConstruct(String s, int k) {
        if(s.length() < k) return false;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }
        int oddCnt = 0;
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() % 2 == 1) oddCnt++;
        }
        if(oddCnt <= k) return true;
        else return false;
    }
}
