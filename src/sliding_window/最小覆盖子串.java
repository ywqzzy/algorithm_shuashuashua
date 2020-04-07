package sliding_window;

import java.util.HashMap;
import java.util.Map;

public class 最小覆盖子串 {
    public String minWindow(String s, String t) {
        int[] tmap = new int[128];
        int[] window = new int[128];

        for(char ch: t.toCharArray()) tmap[ch]++;
        int start = 0, end = 0;
        int cnt = 0;
        String res = "";
        int len = t.length();
        int mn = s.length() + 1;
        while(end < s.length()) {
            char ch = s.charAt(end);
            window[ch]++;
            if(tmap[ch] > 0 && tmap[ch] >= window[ch]) {
                cnt++;
            }
            while(cnt == len) {
                ch = s.charAt(start);
                if(tmap[ch] > 0 && tmap[ch] >= window[ch]) {
                    cnt--;
                }
                window[ch] = window[ch] - 1;
                if((end-start + 1) < mn) {
                    mn = end-start + 1;
                    res = s.substring(start, end + 1);
                }
                start++;
            }
            end++;
        }
        return res;
    }

    public String minWindowWrong(String s, String t) {
        Map<Character, Boolean> map = new HashMap<>();
        int start = 0;
        int end = 0;
        int mn = Integer.MAX_VALUE;
        int minStart = 0;
        int minEnd = 0;
        while(end < s.length()) {
            if(checkCover(map, t)==true) {
                if(end - start < mn) {
                    mn = end - start;
                    minEnd = end;
                    minStart = start;
                }
                map.remove(s.charAt(start));
                start++;
            }
            else {
                map.put(s.charAt(end), true);
                end++;
            }
        }
        return s.substring(minStart, minEnd);
    }

    boolean checkCover(Map<Character, Boolean> map, String t) {
        for(int i = 0; i < t.length(); i++)
            if(!map.containsKey(t.charAt(i))) return false;
        return true;
    }

}
