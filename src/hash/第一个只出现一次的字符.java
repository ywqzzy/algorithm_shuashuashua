package hash;

import java.util.HashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        char[]arr = s.toCharArray();
        for(Character c: arr) {
            if(map.containsKey(c) == false) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for(Character c:arr) {
            if(map.get(c) == 1) return c;
        }
        return ' ';
    }
}
