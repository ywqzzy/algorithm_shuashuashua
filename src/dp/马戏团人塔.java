package dp;

import java.util.Arrays;

public class 马戏团人塔 {
    public int bestSeqAtIndex(int[] height, int[] weight) {
        int len = height.length;
        int[][] person = new int[len][2];
        for(int i = 0; i < len; i++) person[i] = new int[]{height[i], weight[i]};
        Arrays.sort(person, (a, b) -> a[0] == b[0] ? b[1] - a[1]: a[0] - b[0]);
        int []dp = new int[len];
        int res = 0;
        for(int[] pii : person) {
            int idx = Arrays.binarySearch(dp, 0, res, pii[1]);
            if(idx < 0) idx = -(idx + 1);
            dp[idx] = pii[1];
            if(idx == res) res++;
        }
        return res;
    }
}
