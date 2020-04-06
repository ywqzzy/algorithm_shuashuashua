package dp.坐标型dp;

public class 最长连续递增序列 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len == 0) return 0;
        int[] dp = new int[len];
        int res = 0;
        for(int i = 0; i < len; i++) {
            dp[i] = 1;
            if(i>0 && nums[i] > nums[i-1]) dp[i] = dp[i-1] + 1;
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
