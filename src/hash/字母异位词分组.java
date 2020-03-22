package hash;

import java.util.*;

public class 字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return new ArrayList<>();
        int idx = 0;
        for(int i = 0; i < strs.length; i++) {
            String s = sortString(strs[i]);
            if(!map.containsKey(s)) {
                map.put(s, idx);
                idx ++;
                res.add(new ArrayList<>());
            }
            res.get(map.get(s)).add(strs[i]);
        }
        return res;
    }

    public String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return String.valueOf(c);
    }
}
