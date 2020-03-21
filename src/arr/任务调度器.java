package arr;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class 任务调度器 {
    public int leastInterval(char[] tasks, int n) {
        int[] map = new int[26];
        for(int i = 0; i < tasks.length; i++) map[tasks[i] - 'A'] ++;
        Arrays.sort(map);
        int res = (map[25] - 1) * (n + 1) + 1;
        int i = 24;
        while( i>=0 && map[i] == map[25]) {
            res++;
            i--;
        }
        return Math.max(res, tasks.length);
    }
    //如果按照最长的排完之后，后面还有剩下的没有排的，
    // 比如字符串序列式AAABBBCCCD，
    // 然后n=2的话，那拍好就是ABCABCABCD，按
    // 照公式计算出来的结果是(3-1)*(3)+1+2=9，
    // 但是实际的序列应该是ABCABCABCD，
    // 应该是10，所以通过求max来补充掉这个正好全排列但是还有多出去的情况
}
