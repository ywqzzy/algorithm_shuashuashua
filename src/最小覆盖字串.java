import java.util.HashMap;
import java.util.Map;

public class 最小覆盖字串 {
    public String minWindow(String s, String t) {
        Map<Character, Boolean> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int mn = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        while(end < s.length()) {
            map.put(s.charAt(end), true);
            if(end - start >= t.length()) {
                if(checkCover(map, t)==true) {
                    if(end - start < mn) {
                        mn = end - start;
                        minEnd = end;
                        minStart = start;
                    }
                    start++;
                    map.remove(t.charAt(start));
                }
            }
            end++;
        }

        return s.substring(minStart, minEnd);
    }

    boolean checkCover(Map<Character, Boolean> map, String t) {
        for(int i = 0; i < t.length(); i++)
            if(!map.containsKey(t.charAt(i))) return false;
        return true;
    }
}
