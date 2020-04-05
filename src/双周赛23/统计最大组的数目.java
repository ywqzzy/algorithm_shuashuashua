package 双周赛23;

import java.util.HashMap;
import java.util.Map;

public class 统计最大组的数目 {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 1; i<=n; i++) {
            int sum = getSum(i);
            if(map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1);
            } else {
                map.put(sum, 1);
            }
        }
        int mx = Integer.MIN_VALUE;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() >= mx) {
                mx = entry.getValue();
            }
        }
        int res = 0;
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == mx) {
                res++;
            }
        }
        return res;
    }

    static int getSum(int num) {
        int res = 0;
        while(num != 0) {
            res += num %10;
            num /= 10;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(getSum(111));
    }
}
