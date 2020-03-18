import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class 判断是否互为字符重排 {
    public boolean CheckPermutation1(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s1.length(); i++) {
            if(map.get(s1.charAt(i)) == null) {
                map.put(s1.charAt(i), 1);
            } else {
                map.put(s1.charAt(i), map.get(s1.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < s2.length(); i++) {
            if(map.get(s2.charAt(i)) == null) return false;
            else map.put(s2.charAt(i), map.get(s2.charAt(i)) - 1);
        }
        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if(entry.getValue() != 0) return false;
        }
        return true;
    }
}
