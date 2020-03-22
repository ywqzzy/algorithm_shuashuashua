package dp;

public class 分割等和子集 {

    // 0-1背包 近乎裸题

    // 二维写法
    public boolean canPartition1(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int mid = sum / 2;
        boolean[][] dp = new boolean[nums.length+1][mid + 1];
        dp[0][0] = true;
        for(int j = 1; j <= mid; j++) dp[0][j] = false;
        for(int i = 1; i <= nums.length; i++) dp[i][0] = true;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 1; j < dp[0].length; j++) {
                if(nums[i-1] > j) dp[i][j] = dp[i-1][j];
                else {
                    dp[i][j] = (dp[i-1][j-nums[i-1]] || dp[i-1][j]);
                }
            }
        }
        return dp[nums.length][mid];
    }

    // 滚动数组
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num: nums) sum += num;
        if(sum % 2 != 0) return false;
        int mid = sum / 2;
        boolean []dp = new boolean[mid + 1];
        dp[0] = true;
        for(int num: nums) {
            for(int i = mid; i>=num; i--) {
                if(dp[i-num] == true) dp[i] = true;
            }
        }
        return dp[mid];
    }



}
