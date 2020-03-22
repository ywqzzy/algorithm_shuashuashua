package string;

import java.util.HashMap;
import java.util.Map;

public class 罗马数字转整数 {

    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1); map.put('V', 5); map.put('X', 10); map.put('L', 50);
        map.put('C', 100); map.put('D', 500); map.put('M', 1000);
        int res = 0;
        char pre = s.charAt(s.length() - 1);
        res += map.get(pre);
        for(int i = s.length() - 2; i >= 0; i--) {
            if((pre == 'V' || pre=='X')&& s.charAt(i) == 'I') res -= 1;
            else if((pre == 'L' || pre=='C')&& s.charAt(i) == 'X') res -= 10;
            else if((pre == 'D' || pre=='M')&& s.charAt(i) == 'C') res -= 100;
            else {
                res += map.get(s.charAt(i));
                pre = s.charAt(i);
            }
        }
        return res;
    }
}
