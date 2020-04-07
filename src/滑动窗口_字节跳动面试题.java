import java.util.HashSet;
import java.util.Set;

public class 滑动窗口_字节跳动面试题 {
    public static int findIndex(char[] arr, String s) {
        int m = arr.length;
        int n = s.length();
        int start = 0;
        Set<Character> sets = new HashSet<>();
        Set<Character> window = new HashSet<>();
        for(char c: arr) sets.add(c);
        for(int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(sets.contains(c) && !window.contains(c)) {
                window.add(c);
                if(window.size() == m) return start;
            } else if(sets.contains(c) && window.contains(c)) {
                while(s.charAt(start) != c) {
                    window.remove(s.charAt(start));
                    start++;
                }
                start++;
            } else {
                start = i + 1;
                window.clear();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String s="tbcacbdata";
        char[] arr=new char[]{'a','b','c','d'};
        System.out.println(findIndex(arr, s));
    }

}
