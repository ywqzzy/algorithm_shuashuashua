package dp;

public class 目标和 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(Math.abs(S) > Math.abs(sum)) return 0;
        int len = nums.length;
        int t = sum * 2 + 1; // 超级重点
        int[][] dp = new int[len][t];
        if(nums[0] == 0) dp[0][sum] = 2;
        else {
            dp[0][sum + nums[0]] = 1;
            dp[0][sum - nums[0]] = 1;
        }
        for(int i = 1; i < len; i++) {
            for(int j = 0; j < t; j++) {
                int left = (j - nums[i]) >= 0 ? j - nums[i] : 0; // +
                int right = (j + nums[i] < t) ? j + nums[i] : 0; // -
                dp[i][j] = dp[i-1][left] + dp[i-1][right];
            }
        }
        return dp[len - 1][sum + S];
    }
}
