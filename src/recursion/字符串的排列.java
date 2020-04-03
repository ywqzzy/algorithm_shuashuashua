package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class 字符串的排列 {
    List<String> res = new LinkedList<>();
    char[] carr;
    public String[] permutation(String s) {
        if(s == null) return new String[0];
        if(s.length() == 0) return new String[0];
        carr = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }
    void dfs(int x) {
        if(x == carr.length - 1) {
            res.add(String.valueOf(carr));
            return;
        }
        HashSet<Character> set = new HashSet<>();
        for(int i = x; i < carr.length; i++) {
            if(set.contains(carr[i])) continue;
            set.add(carr[i]);
            swap(i, x);
            dfs(x + 1);
            swap(i, x);
        }
    }

    void swap(int a, int b) {
        char temp = carr[a];
        carr[a] = carr[b];
        carr[b] = temp;
    }
}
