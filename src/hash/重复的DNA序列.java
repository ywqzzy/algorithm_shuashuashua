package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 重复的DNA序列 {

    // 1. 插入一个字符串
    // 2. 统计字符串出现的次数

    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0; i + 10 <= s.length(); i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
            if(map.get(str) == 2) res.add(str);
        }
        return res;
    }
}
